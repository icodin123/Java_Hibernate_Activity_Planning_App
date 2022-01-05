import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.UserService;

/**
 * Login service that provides sign in/sign up functionality.
 *
 * @version 1.0
 * @since 1.0
 */
public class LoginServiceImpl implements LoginService,
        NotificationServiceConsumer {

    /*
     * Current user.
     */
    private static User currentUser;

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    /*
     * tools for showing notifications.
     */
    private NotificationService notificationService;

    LoginServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void showPopup(String title, String message) {
        this.notificationService.showNotification(title, message);
    }

    @Override
    public boolean logIn(String username, String password) {
        UserService userService = new UserService();
        try {
            User user = userService.findUser(username);
            if (user != null) {

                if (passwordCheck(password, user)) {
                    System.out.println("The password matches.");
                    System.out.println("login successful.");
                    currentUser = user;
                    showPopup("Message",
                            "Login successful.");
                    return true;
                } else {
                    System.out.println("The password does not match.");

                    showPopup("Message",
                            "The password does not match.");
                }
            } else {
                showPopup("Message",
                        "User with specified username does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Could not load user from database.");
        }

        return false;
    }

    /**
     * Return whether entered password matches user's password.
     *
     * @param password that was entered
     * @param user     account of user
     * @return whether entered password matches user's password.
     */
    private boolean passwordCheck(String password, User user) {
        return BCrypt.checkpw(password, user.getPassword());
    }

    /**
     * Return whether entered password is valid.
     *
     * @param password that was entered
     * @return whether entered password is valid.
     */
    private boolean isValidPassword(String password) {
        return password.length() >= 5;
    }

    /**
     * Create account using given username and password.
     *
     * @param username entered by user.
     * @param password entered by user.
     */
    private void createAccount(String username, String password) {
        UserService userService = new UserService();
        User user = new User(username, password);
        currentUser = user;
        userService.saveUser(user);

        showPopup("Message",
                "Account was successfully created.");

    }

    @Override
    public boolean signUp(String username, String password) {
        UserService userService = new UserService();
        User user = userService.findUser(username);
        if (user == null) {
            System.out.println("Username's free");
            if (isValidPassword(password)) {
                createAccount(username, password);
                return true;
            } else {
                System.out.println("invalid password");
            }
        } else {
            System.out.println("User with this username already exists.");

            showPopup("User already exists",
                    "User with this username already exists.");

        }
        return false;
    }
}
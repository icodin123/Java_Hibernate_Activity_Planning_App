import models.User;

/**
 * Interface for log in/sign up functionality.
 *
 * @version 1.0
 * @since 1.0
 */
public interface LoginService {

    /**
     * Log user into account by using provided credentials and return
     * whether operation was successful.
     *
     * @param username of the user
     * @param password of the user
     * @return whether operation was successful.
     */
    boolean logIn(String username, String password);

    /**
     * Help user sign up using entered username and password and
     * return whether operation was successful.
     *
     * @param username entered by user.
     * @param password entered by user.
     * @return whether operation was successful.
     */
    boolean signUp(String username, String password);

    /**
     * Return current user.
     *
     * @return current user.
     */
    User getCurrentUser();
}

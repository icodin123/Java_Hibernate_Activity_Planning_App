import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Manages UI for log in/sign up functionality.
 *
 * @version 1.0
 * @since 1.0
 */
public class LoginScreen extends JFrame implements LoginServiceConsumer {

    /*
     * tools for logging in and signing up users.
     */
    private final LoginService loginService;

    @Override
    public boolean logIn(String username, String password) {
        return loginService.logIn(username, password);
    }

    @Override
    public boolean signUp(String username, String password) {
        return loginService.signUp(username, password);
    }

    @Override
    public void activate() {
        setVisible(true);
    }

    /**
     * Transition to TaskList frame and dispose of the current frame.
     */
    private void transitionToTaskList() {
        TaskListServiceInjector taskListServiceInjector =
                new TaskListServiceInjectorImpl();
        dispose();
        taskListServiceInjector.getConsumer().activate();
    }

    LoginScreen(LoginService loginService) {
        super("Login");
        this.loginService = loginService;
        this.setBounds(100, 100, 800, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));

        final JTextField usernameInput = new JTextField("admin",
                5);
        final JTextField passwordInput = new JTextField("password123",
                5);
        JLabel usernameText = new JLabel("Username:");
        JLabel passwordText = new JLabel("Password:");
        container.add(usernameText);
        container.add(usernameInput);
        container.add(passwordText);
        container.add(passwordInput);

        setupLogInButton(usernameInput, passwordInput);
        setupSignUpButton(usernameInput, passwordInput);
    }

    /**
     * Add listeners to log in button.
     *
     * @param usernameInput text input field.
     * @param passwordInput text input field.
     */
    private void setupLogInButton(final JTextField usernameInput, final
    JTextField passwordInput) {
        JButton loginButton = new JButton("Sign in");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (logIn(usernameInput.getText(),
                        passwordInput.getText())) {

                    transitionToTaskList();

                }

            }
        });

        getContentPane().add(loginButton);
    }

    /**
     * Add listeners to sign up button.
     *
     * @param usernameInput text input field.
     * @param passwordInput text input field.
     */
    private void setupSignUpButton(final JTextField usernameInput, final
    JTextField passwordInput) {
        JButton registerButton = new JButton("Sign up");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp(usernameInput.getText(),
                        passwordInput.getText());
            }
        });
        getContentPane().add(registerButton);
    }
}
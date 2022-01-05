/**
 * Interface for consumer of login service.
 *
 * @version 1.0
 * @since 1.0
 */
public interface LoginServiceConsumer {

    /**
     * Log user into the system and return whether operation was
     * successful.
     *
     * @param username user's username.
     * @param password user's password.
     * @return whether operation was successful.
     */
    boolean logIn(String username, String password);

    /**
     * Create new user account and return whether operation was successful.
     *
     * @param username user's username.
     * @param password user's password.
     * @return whether operation was successful.
     */
    boolean signUp(String username, String password);

    /**
     * Activate consumer.
     */
    void activate();
}
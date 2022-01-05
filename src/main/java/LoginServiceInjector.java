/**
 * Interface for log in service injector.
 *
 * @version 1.0
 * @since 1.0
 */
public interface LoginServiceInjector {

    /**
     * Return a consumer of login service.
     */
    LoginServiceConsumer getConsumer();
}

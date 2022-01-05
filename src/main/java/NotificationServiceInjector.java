/**
 * Interface for notification service injector.
 *
 * @version 1.0
 * @since 1.0
 */
public interface NotificationServiceInjector {

    /**
     * Return a consumer of notification service.
     */
    NotificationServiceConsumer getConsumer();
}

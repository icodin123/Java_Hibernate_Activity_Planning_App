/**
 * Notification service injector.
 *
 * @version 1.0
 * @since 1.0
 */
public class NotificationServiceInjectorImpl implements
        NotificationServiceInjector {

    @Override
    public NotificationServiceConsumer getConsumer() {
        return new LoginServiceImpl(new NotificationServiceImpl());
    }
}

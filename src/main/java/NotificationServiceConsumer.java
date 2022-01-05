/**
 * Interface for consumer of notification service.
 *
 * @version 1.0
 * @since 1.0
 */
public interface NotificationServiceConsumer {
    /**
     * Show notification using given title and message.
     *
     * @param title   of notification.
     * @param message of notification.
     */
    void showPopup(String title, String message);
}

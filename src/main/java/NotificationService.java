/**
 * Interface for notification service that provides tools for showing
 * notifications to app user.
 *
 * @version 1.0
 * @since 1.0
 */
public interface NotificationService {

    /**
     * Show popup with given title and message.
     *
     * @param title   to be shown.
     * @param message to be displayed.
     */
    void showNotification(String title, String message);
}

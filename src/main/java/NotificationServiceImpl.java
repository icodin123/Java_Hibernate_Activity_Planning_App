import javax.swing.*;

/**
 * Notification service that provides tools for showing
 * notifications to app user.
 *
 * @version 1.0
 * @since 1.0
 */
class NotificationServiceImpl implements NotificationService {

    @Override
    public void showNotification(String title, String message) {
        JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.PLAIN_MESSAGE);
    }
}

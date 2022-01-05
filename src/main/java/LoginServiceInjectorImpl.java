/**
 * Log in service injector.
 *
 * @version 1.0
 * @since 1.0
 */
public class LoginServiceInjectorImpl implements LoginServiceInjector {

    @Override
    public LoginServiceConsumer getConsumer() {
        NotificationServiceInjector notificationServiceInj = new NotificationServiceInjectorImpl();
        return new LoginScreen((LoginServiceImpl) notificationServiceInj.getConsumer());
    }
}

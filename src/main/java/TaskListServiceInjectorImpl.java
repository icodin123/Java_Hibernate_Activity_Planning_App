/**
 * Task List Service Injector.
 *
 * @version 1.0
 * @since 1.0
 */
public class TaskListServiceInjectorImpl implements TaskListServiceInjector {

    @Override
    public TaskListConsumer getConsumer() {
        NotificationServiceInjector service = new
                NotificationServiceInjectorImpl();
        return new TaskList(new TaskListServiceImpl((LoginServiceImpl) service.
                getConsumer(), new NotificationServiceImpl()));
    }
}

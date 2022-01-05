/**
 * Interface for Task List Service Injector.
 *
 * @version 1.0
 * @since 1.0
 */
public interface TaskListServiceInjector {

    /**
     * Return a consumer of task list service.
     */
    TaskListConsumer getConsumer();
}

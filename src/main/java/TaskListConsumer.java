import models.Task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Interface for task list service consumer.
 *
 * @version 1.0
 * @since 1.0
 */
public interface TaskListConsumer {

    /**
     * Create a task with given name and return whether operation was
     * successful.
     *
     * @param taskName name of the task.
     * @return whether operation was successful.
     */
    boolean createTask(String taskName);

    /**
     * Set current date to the given date.
     *
     * @param date given date.
     */
    void modifyDate(Calendar date);

    /**
     * Return list of tasks that were created by current user on given date.
     *
     * @param date given date.
     * @return list of tasks that were created on given date by current user.
     */
    List<Task> getTasksByDate(Date date);

    /**
     * Return the list of all tasks that were created by current user.
     *
     * @return list of tasks that were created by current user.
     */
    List<Task> getTasks();

    /**
     * Update the given instance of task.
     *
     * @param task that needs to be updated.
     */
    void updateTask(Task task);

    /**
     * Activate task list.
     */
    void activate();
}

import models.Task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Interface for task list service that provides functionality for managing
 * tasks.
 *
 * @version 1.0
 * @since 1.0
 */
public interface TaskListService {

    /**
     * Create new task with given name and return whether operation was
     * successful.
     *
     * @param taskName name of the task to be created.
     * @return whether operation was successful.
     */
    boolean createNewTask(String taskName);

    /**
     * Set date.
     *
     * @param date new date.
     */
    void setDate(Calendar date);

    /**
     * Return tasks of current user that were created on given date.
     *
     * @param date that tasks were created.
     * @return list of tasks of current user that were created on given date.
     */
    List<Task> loadUsersTasksByDate(Date date);

    /**
     * Return tasks of current user.
     *
     * @return list of tasks of current use.
     */
    List<Task> loadUsersTasks();

    /**
     * Store task changes.
     *
     * @param task that needs to be updated.
     */
    void saveTaskChanges(Task task);
}

package services;

import dao.TaskDao;
import dao.TaskDaoImpl;
import models.Task;

import java.sql.SQLException;

/**
 * Service for operating on tasks.
 *
 * @version 1.0
 * @since 1.0
 */
public class TaskService {

    /**
     * User Data Access Object.
     */
    private TaskDao tasksDao = new TaskDaoImpl();

    public TaskService() {

    }

    /**
     * Update given task in the database.
     *
     * @param task given task.
     */
    public void updateTask(Task task) {
        try {
            tasksDao.updateTask(task);
        } catch (SQLException e) {
            System.out.println("Unable to update task. " + e);
        }
    }
}

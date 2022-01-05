package dao;

import models.Task;

import java.sql.SQLException;

/**
 * Interface for Task Data Access Object.
 *
 * @version 1.0
 * @since 1.0
 */
public interface TaskDao {

    /**
     * Update given task in the database.
     *
     * @param task given task.
     */
    void updateTask(Task task) throws SQLException;
}

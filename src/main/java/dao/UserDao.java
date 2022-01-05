package dao;

import models.Task;
import models.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Interface for User Data Access Object.
 *
 * @version 1.0
 * @since 1.0
 */
public interface UserDao {

    /**
     * Find and return a user with the given id.
     *
     * @param name of a user that we need to find.
     * @return user with given id.
     */
    User findByName(String name) throws SQLException;

    /**
     * Store given user in the database.
     *
     * @param user given user.
     */
    void save(User user) throws SQLException;

    /**
     * Update user in the database.
     *
     * @param user that needs to be updated in the database.
     */
    void update(User user) throws SQLException;

    /**
     * Delete user from the database.
     *
     * @param user that needs to be deleted from the database.
     */
    void delete(User user) throws SQLException;

    /**
     * Find and return task with the given id from the database.
     *
     * @param id of the task that we need to find.
     */
    Task findTaskById(int id) throws SQLException;

    /**
     * Return list of all users in the database.
     *
     * @return list of users from the database.
     */
    List<User> findAll() throws SQLException;

    /**
     * Return list of tasks with specified date and user from database.
     *
     * @param date when tasks were created.
     * @param user that created tasks.
     * @return tasks with given date and user.
     */
    List<Task> findTasksByDateAndUser(Date date, User user) throws SQLException;

    /**
     * Return list of tasks created by given user from database.
     *
     * @param user that created tasks.
     * @return list of tasks created by given user.
     */
    List<Task> findTasksByUser(User user) throws SQLException;

    /**
     * Return list of all tasks from database.
     *
     * @return list of all tasks.
     */
    List<Task> findAllTasks() throws SQLException;
}

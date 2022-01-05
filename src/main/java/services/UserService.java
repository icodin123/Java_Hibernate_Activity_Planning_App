package services;

import dao.UserDaoImpl;
import dao.UserDao;
import models.Task;
import models.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Service for operating on users.
 *
 * @version 1.0
 * @since 1.0
 */
public class UserService {

    /**
     * User Data Access Object.
     */
    private final UserDao usersDao = new UserDaoImpl();

    public UserService() {
    }

    /**
     * Return the user with a given id from the database.
     *
     * @param name name of the user that needs to be found.
     * @return user with the given id.
     */
    public User findUser(String name) {
        try {
            return usersDao.findByName(name);
        } catch (SQLException e) {
            System.out.println("Unable to find user with id. " + e);
            return null;
        }
    }

    /**
     * Store user in the database.
     *
     * @param user to be saved.
     */
    public void saveUser(User user) {
        try {
            usersDao.save(user);
        } catch (SQLException e) {
            System.out.println("Unable to save user. " + e);
        }
    }

    /**
     * Delete user from database.
     *
     * @param user to be deleted.
     */
    public void deleteUser(User user) {
        try {
            usersDao.delete(user);
        } catch (SQLException e) {
            System.out.println("Unable to delete user. " + e);
        }
    }

    /**
     * Update user in the database.
     *
     * @param user to be updated.
     */
    public void updateUser(User user) {
        try {
            usersDao.update(user);
        } catch (SQLException e) {
            System.out.println("Unable to update user. " + e);
        }
    }

    /**
     * Return list of all users stored in the database.
     *
     * @return list of all users.
     */
    public List<User> findAllUsers() {
        try {
            return usersDao.findAll();
        } catch (SQLException e) {
            System.out.println("Unable to load all users. " + e);
            return null;
        }
    }

    /**
     * Return task from the database by its id.
     *
     * @param id of the task that we need to find.
     * @return task with given id.
     */
    public Task findTaskById(int id) {
        try {
            return usersDao.findTaskById(id);
        } catch (SQLException e) {
            System.out.println("Unable to find task with id. " + e);
            return null;
        }
    }

    /**
     * Return list of tasks with specified date and user from database.
     *
     * @param date when tasks were created.
     * @param user that created tasks.
     * @return tasks with given date and user.
     */
    public List<Task> findTasksByDateAndUser(Date date, User user) {
        try {
            return usersDao.findTasksByDateAndUser(date, user);
        } catch (SQLException e) {
            System.out.println("Unable to find task with date and user. " + e);
            return null;
        }
    }

    /**
     * Return list of tasks created by given user from database.
     *
     * @param user that created tasks.
     * @return list of tasks created by given user.
     */
    public List<Task> findTasksByUser(User user) {
        try {
            return usersDao.findTasksByUser(user);
        } catch (SQLException e) {
            System.out.println("Unable to find task with user. " + e);
            return null;
        }
    }

    /**
     * Return list of all tasks from database.
     *
     * @return list of all tasks.
     */
    public List<Task> findAllTasks() {
        try {
            return usersDao.findAllTasks();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
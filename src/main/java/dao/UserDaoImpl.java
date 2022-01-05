package dao;

import models.Task;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User Data Access Object.
 *
 * @version 1.0
 * @since 1.0
 */
public class UserDaoImpl implements UserDao {

    public User findByName(String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, name);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Task findTaskById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Task.class, id);
    }

    public List<Task> findTasksByDateAndUser(Date date, User user) {
        List<Task> allTasks = findAllTasks();
        List<Task> result = new ArrayList<Task>();
        for (Task allTask : allTasks) {
            if (allTask.getUser().getName().equals(user.getName()) &&
                    allTask.getDate().equals(date)) {
                result.add(allTask);
            }
        }
        return result;
    }

    public List<Task> findTasksByUser(User user) {
        List<Task> allTasks = findAllTasks();
        List<Task> result = new ArrayList<Task>();
        for (Task allTask : allTasks) {
            if (allTask.getUser().getName().equals(user.getName())) {
                result.add(allTask);
            }
        }
        return result;
    }

    public List<Task> findAllTasks() {
        return (List<Task>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(
                "From Task").list();
    }

    public List<User> findAll() {
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(
                "From User").list();
    }
}

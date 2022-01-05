package dao;

import models.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

/**
 * Task Data Access Object.
 *
 * @version 1.0
 * @since 1.0
 */
public class TaskDaoImpl implements TaskDao {

    public void updateTask(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        session.merge(task);
        tx1.commit();
        session.close();
    }
}

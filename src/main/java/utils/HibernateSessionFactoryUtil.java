package utils;

import models.Task;
import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Manages Hibernate Session.
 *
 * @version 1.0
 * @since 1.0
 */
public class HibernateSessionFactoryUtil {

    /**
     * Current session factory.
     */
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    /**
     * Return current session factory.
     *
     * @return current session factory.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Task.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Unable to create new session factory. " + e);
            }
        }
        return sessionFactory;
    }
}
/**
 * To-Do List Java-based application built using the following:
 * Maven, Hibernate, Java Persistence API, Data Access Object(DAO) Design
 * Pattern, Swing, Hibernate Query Language(HQL), ORM(Object-relational
 * Mapping), Data Access/Integration Part of the Spring Framework,
 * PostgresQL(database), Dependency Injection Design Pattern,
 * BCrypt for Password Hashing.
 *
 * @version 1.0
 * @since 1.0
 */
public class Main {

    public static void main(String[] arg) {
        // get login service consumer
        LoginServiceInjector loginServiceInjector = new LoginServiceInjectorImpl();
        LoginServiceConsumer app = loginServiceInjector.getConsumer();

        // enable login service consumer
        app.activate();
    }
}
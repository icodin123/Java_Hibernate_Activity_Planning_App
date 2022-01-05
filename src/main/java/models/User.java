package models;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User class represents user account.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    /*
     * user's id.
     */
    private String name;

    @Column(name = "password")
    /*
     * user's password.
     */
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    /*
     * list of user's tasks.
     */
    private List<Task> tasks;

    /**
     * Return user's password.
     *
     * @return user's password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set user's password.
     *
     * @param password new password for user.
     */
    void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        tasks = new ArrayList<Task>();
        setPassword(password);
    }

    /**
     * Add task to user.
     *
     * @param task to be added.
     */
    public void addTask(Task task) {
        task.setUser(this);
        tasks.add(task);
    }

    /**
     * Remove task from user.
     *
     * @param task to be removed.
     */
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Return user's name.
     *
     * @return user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Return list of user's tasks.
     *
     * @return list of user's tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Update user's tasks.
     *
     * @param tasks new list of tasks for user.
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "models.User{" +
                ", name='" + name + '\'' +
                '}';
    }
}
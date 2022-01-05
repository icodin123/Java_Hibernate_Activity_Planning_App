package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Task represents an activity planned by user. Contains task name,
 * date and completion status of the task.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "tasks", schema = "public")
public class Task {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     * task's id.
     */
    private Integer id;

    @Column(name = "name")
    /*
     * task's name.
     */
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    /*
     * the date when task was created.
     */
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name")
    /*
     * current owner of the task.
     */
    private User user;

    @Column(name = "completed")
    /*
     * indicates whether task was completed.
     */
    private boolean completed;

    /**
     * Return whether task is completed.
     *
     * @return whether task is completed.
     */
    public boolean getCompleted() {
        return completed;
    }

    /*
     * Set whether task is completed.
     * @param completed new value that indicates whether task is completed.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task() {
    }

    public Task(String name, Date date, User user) {
        this.name = name;
        this.date = date;
        this.user = user;
        this.completed = false;
    }

    /**
     * Return task's id.
     *
     * @return tasks's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Return task's name.
     *
     * @return tasks's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Return task's date.
     *
     * @return tasks's date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set task's name.
     *
     * @param name new task's name.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Set task's date.
     *
     * @param date task's date.
     */
    void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    /**
     * Set task's user.
     *
     * @param user new user for the task.
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return name + " " + date;
    }
}
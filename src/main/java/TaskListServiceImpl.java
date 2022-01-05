import models.Task;
import models.User;
import services.TaskService;
import services.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Task list service that provides functionality for managing
 * tasks.
 *
 * @version 1.0
 * @since 1.0
 */
public class TaskListServiceImpl implements TaskListService,
        NotificationServiceConsumer {

    /*
     * current date selection.
     */
    private Calendar curDate;

    /*
     * tool for managing user accounts.
     */
    private final LoginService loginService;

    /*
     * tool for showing notifications.
     */
    private final NotificationService notificationService;

    @Override
    public void showPopup(String title, String message) {
        notificationService.showNotification(title, message);
    }

    TaskListServiceImpl(LoginService loginService,
                        NotificationService notificationService) {
        this.loginService = loginService;
        this.notificationService = notificationService;
    }

    @Override
    public boolean createNewTask(String taskName) {
        if (curDate == null || loginService.getCurrentUser() ==
                null) {
            showPopup("Warning",
                    "First you need to select the date.");
            return false;
        } else {
            UserService userService = new UserService();
            Task task = new Task(taskName, curDate.getTime(),
                    loginService.getCurrentUser());
            task.setUser(loginService.getCurrentUser());

            loginService.getCurrentUser().addTask(task);
            userService.updateUser(loginService.
                    getCurrentUser());

            showPopup("Message",
                    "Task was successfully created.");

            return true;
        }
    }

    @Override
    public void setDate(Calendar date) {
        this.curDate = date;
    }

    @Override
    public List<Task> loadUsersTasksByDate(Date date) {
        UserService userService = new UserService();
        return userService.findTasksByDateAndUser(date,
                loginService.getCurrentUser());
    }

    @Override
    public List<Task> loadUsersTasks() {
        UserService userService = new UserService();
        return userService.findTasksByUser(
                loginService.getCurrentUser());
    }

    @Override
    public void saveTaskChanges(Task task) {
        TaskService taskService = new TaskService();
        taskService.updateTask(task);
        List<Task> tasks = loadUsersTasks();
        UserService userService = new UserService();
        User current_user = loginService.getCurrentUser();
        current_user.setTasks(tasks);
        userService.updateUser(current_user);

        showPopup("Message",
                "Task status was successfully updated.");
    }
}
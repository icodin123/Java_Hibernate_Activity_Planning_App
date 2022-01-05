import models.Task;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.*;

/**
 * Class that manages task list UI representation.
 *
 * @version 1.0
 * @since 1.0
 */
public class TaskList extends JFrame implements TaskListConsumer {

    /*
     * table.
     */
    private JTable table;

    /*
     * table model.
     */
    private SimpleTableModel tableModel;

    /*
     * scroll pane.
     */
    private JScrollPane scrollPane;

    /*
     * button for selecting date.
     */
    private final JButton dateButton = new JButton("Select date");

    /*
     * current tasks.
     */
    private java.util.List<Task> tasks = new ArrayList<Task>();

    /*
     * tool for operating on tasks.
     */
    private final TaskListService taskListService;

    @Override
    public boolean createTask(String taskName) {
        return taskListService.createNewTask(taskName);
    }

    @Override
    public void modifyDate(Calendar date) {
        taskListService.setDate(date);
    }

    @Override
    public java.util.List<Task> getTasksByDate(Date date) {
        return taskListService.loadUsersTasksByDate(date);
    }

    @Override
    public List<Task> getTasks() {
        return taskListService.loadUsersTasks();
    }

    @Override
    public void updateTask(Task task) {
        taskListService.saveTaskChanges(task);
    }

    @Override
    public void activate() {
        setVisible(true);
    }

    /**
     * Set up the j-table.
     */
    private void setupTable() {
        Vector dataVector = new Vector();
        tasks = getTasks();

        for (int i = 0; i < tasks.size(); i++) {
            dataVector.addElement(tasks.get(i));
            System.out.println("task " + tasks.get(i).getName() + " " + tasks.get(i).getCompleted());
        }
        tableModel = new SimpleTableModel(dataVector);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
        scrollPane.updateUI();
        getContentPane().repaint();
        scrollPane.updateUI();
    }

    /**
     * Update j-table with relevant data.
     */
    private void updateTable() {
        Vector dataVector = new Vector();
        tasks = getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            dataVector.addElement(tasks.get(i));
            System.out.println("task " + tasks.get(i).getName() + " " + tasks.get(i).getCompleted());
        }
        tableModel = new SimpleTableModel(dataVector);
        table.setModel(tableModel);
    }

    TaskList(TaskListService taskListService) {
        super("Task List");

        this.taskListService = taskListService;

        this.setBounds(100, 100, 800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupTable();
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 1, 2, 2));
        final String defaultText = "Enter the name of your task here...";
        final JTextField inputField = new JTextField(defaultText,
                5);
        getContentPane().add(scrollPane);
        container.add(inputField);
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (inputField.getText().equals(defaultText)) {
                    inputField.setText("");
                } else if (inputField.getText().length() >= 20)
                    e.consume();
            }
        });
        JButton createTaskButton = new JButton("Create new task");
        createTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (createTask(
                        inputField.getText())) {
                    updateTable();
                    System.out.println("Task created");
                }
            }
        });
        dateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transitionToDatePicker();
            }
        });
        JButton markButton = new JButton("Mark as Done/Undone");

        markButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tasks.size() != 0) {
                    int row = table.getSelectedRow();
                    if (row < 0 || row >= tasks.size()) {
                        return;
                    }
                    Task task = tasks.get(row);
                    task.setCompleted(!task.getCompleted());
                    updateTask(task);
                    updateTable();
                    System.out.println("Task updated");
                }
            }
        });

        container.add(markButton);
        container.add(createTaskButton);
        container.add(dateButton);
    }

    /**
     * Open date picker.
     */
    private void transitionToDatePicker() {
        JLabel label = new JLabel("Selected Date:");
        final JTextField text = new JTextField(20);
        JButton b = new JButton("popup");
        JPanel p = new JPanel();
        p.add(label);
        p.add(text);
        p.add(b);
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Calendar cal = new DatePicker(f).getPickedDate();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                        "dd-MM-yyyy");
                if (cal != null) {
                    String dateString = sdf.format(cal.getTime());
                    text.setText(dateString);
                    modifyDate(cal);
                    dateButton.setText("Date: " + dateString);
                }
            }
        });
    }
}

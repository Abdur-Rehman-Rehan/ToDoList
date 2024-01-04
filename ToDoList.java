package TodoList;

import TodoList.Listeners.SaveTasksOnCloseListener;
import TodoList.Listeners.ButtonActionListeners.AddTaskActionListener;
import TodoList.Listeners.ButtonActionListeners.CompleteTaskActionListener;
import TodoList.Listeners.ButtonActionListeners.DeleteTaskActionListener;
import TodoList.Listeners.ButtonActionListeners.ModifyTaskActionListener;
import TodoList.Style.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI is created on the event dispatch thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(600, 400);

        // Created components
        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<Task> listModel = new DefaultListModel<>();
        JList<Task> taskList = new JList<>(listModel);
        taskList.setCellRenderer(new TaskCellRenderer());
        JScrollPane scrollPane = new JScrollPane(taskList);
        JTextField taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete");
        JButton completeButton = new JButton("Completed");
        JButton uncompleteButton = new JButton("Incomplete");
        JButton modifyButton = new JButton("Modify Task");

        
        File file = new File("TodoList\\tasks.txt");// Change this to the path of your tasks.txt file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String taskLine = scanner.nextLine();
                boolean isCompleted = taskLine.startsWith("[x] ");
                String taskName = taskLine.substring(4);
                listModel.addElement(new Task(taskName, isCompleted));
            }
        } catch (FileNotFoundException e) {
            // File not found, ignore
        }


        // Style the GUI
        StyleManager.beautify(frame, taskList, taskInput, addButton, deleteButton, completeButton, uncompleteButton,modifyButton,panel,scrollPane);


        // ActionListeners for buttons

        //Close action listener
        SaveTasksOnCloseListener saveTasksOnCloseListener = new SaveTasksOnCloseListener(listModel, file);
        frame.addWindowListener(saveTasksOnCloseListener);

        //Add Task action listener
        AddTaskActionListener addTaskActionListener = new AddTaskActionListener(listModel, taskInput);
        addButton.addActionListener(addTaskActionListener);

        //Delete Task action listener
        DeleteTaskActionListener deleteTaskActionListener = new DeleteTaskActionListener(listModel, taskList);
        deleteButton.addActionListener(deleteTaskActionListener);

        //Modify Task action listener
        ModifyTaskActionListener modifyTaskActionListener = new ModifyTaskActionListener(listModel, taskList, taskInput);
        modifyButton.addActionListener(modifyTaskActionListener);

        //Complete Task action listener
        CompleteTaskActionListener completeTaskActionListener = new CompleteTaskActionListener(listModel, taskList);
        completeButton.addActionListener(completeTaskActionListener);
    }
}

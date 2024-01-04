package TodoList;

import javax.swing.*;
import java.awt.*;

public class ToDoList {
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI is created on the event dispatch thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(600, 400);


        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<Task> listModel = new DefaultListModel<>();
        JList<Task> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        JTextField taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete");
        JButton completeButton = new JButton("Completed");
        JButton uncompleteButton = new JButton("Uncompleted");
        JButton modifyButton = new JButton("Modify Task");

        
    }
}

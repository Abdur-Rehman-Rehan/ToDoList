package TodoList.Style;

import TodoList.Task;

import javax.swing.*;
import java.awt.*;

public class StyleManager {

    public static void beautify(JFrame frame, JList<Task> taskList, JTextField taskInput, JButton addButton, JButton deleteButton, JButton completeButton, JButton uncompleteButton, JButton modifyButton, JPanel panel, JScrollPane scrollPane) {

        // Set fonts
        Font bigBoldFont = new Font(taskList.getFont().getName(), Font.BOLD, 18);
        taskList.setFont(bigBoldFont);
        taskInput.setFont(bigBoldFont);
        addButton.setFont(bigBoldFont);
        deleteButton.setFont(bigBoldFont);
        completeButton.setFont(bigBoldFont);
        uncompleteButton.setFont(bigBoldFont);
        modifyButton.setFont(bigBoldFont);

        // Set dark theme colors
        setDarkTheme(frame, taskList, taskInput, addButton, deleteButton, completeButton,
                uncompleteButton, modifyButton, panel, scrollPane);

        // Set text color
        Color textColor = new Color(255, 255, 255);
        taskInput.setForeground(textColor);
        addButton.setForeground(textColor);
        deleteButton.setForeground(textColor);
        completeButton.setForeground(textColor);
        uncompleteButton.setForeground(textColor);
        modifyButton.setForeground(textColor);

        // Set button backgrounds
        addButton.setBackground(new Color(30, 21, 55)); // #ced802
        deleteButton.setBackground(new Color(117, 11, 25)); // #871005
        completeButton.setBackground(new Color(35, 163, 15)); // #098705
        uncompleteButton.setBackground(new Color(0, 53, 84)); // #056687
        modifyButton.setBackground(new Color(58, 19, 58)); // #000000

        // Configure input and button panels
        configurePanels(taskInput, addButton, deleteButton, completeButton,
                uncompleteButton, modifyButton, panel, scrollPane);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private static void setDarkTheme(Component... components) {
        Color darkColor = new Color(44, 44, 44);
        for (Component component : components) {
            component.setBackground(darkColor);
        }
    }

    private static void configurePanels(JTextField taskInput, JButton addButton, JButton deleteButton, JButton completeButton, JButton uncompleteButton, JButton modifyButton, JPanel panel, JScrollPane scrollPane) {
        
        
        // Panel configurations
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.setBackground(panel.getBackground());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(uncompleteButton);
        buttonPanel.add(modifyButton);
        buttonPanel.setBackground(panel.getBackground());

        panel.setLayout(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }
}


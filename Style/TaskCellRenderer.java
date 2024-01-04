package TodoList.Style;

import TodoList.Task;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TaskCellRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Task task = (Task) value;
        
        // Set dark theme colors
        setDarkTheme(list, label, isSelected);

        // Set task completion styles
        if (task.isCompleted()) {
            label.setText("<html><s>" + task.getName() + "</s></html>");
            label.setForeground(new Color(21, 255, 4)); // Set text color to green for completed tasks
        } else {
            label.setForeground(new Color(255, 255, 255)); // Set text color to the default color for incomplete tasks
        }

        return label;
    }

    private void setDarkTheme(JList<?> list, JLabel label, boolean isSelected) {
        // Dark background for the list
        list.setBackground(new Color(30, 30, 30));

        // Dark border
        final Border darkBorder = BorderFactory.createLineBorder(new Color(50, 50, 50), 3);
        label.setBorder(darkBorder);

        // Set selection background for the list
        if (isSelected) {
            label.setBackground(new Color(15, 76, 92));
        } else {
            label.setBackground(new Color(30, 30, 30));
        }

        // Set text color
        label.setForeground(new Color(255, 255, 255));
    }
}

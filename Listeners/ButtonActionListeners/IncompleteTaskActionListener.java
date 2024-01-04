package TodoList.Listeners.ButtonActionListeners;

import TodoList.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class IncompleteTaskActionListener implements ActionListener {
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;

    public IncompleteTaskActionListener(DefaultListModel<Task> listModel, JList<Task> taskList) {
        this.listModel = listModel;
        this.taskList = taskList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task selectedTask = listModel.getElementAt(selectedIndex);
            selectedTask.setCompleted(false);
            taskList.repaint();
        }
    }
}

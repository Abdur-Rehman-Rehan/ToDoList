package TodoList.Listeners.ButtonActionListeners;

import TodoList.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ModifyTaskActionListener implements ActionListener {
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JTextField taskInput;

    public ModifyTaskActionListener(DefaultListModel<Task> listModel, JList<Task> taskList, JTextField taskInput) {
        this.listModel = listModel;
        this.taskList = taskList;
        this.taskInput = taskInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1 && !taskInput.getText().trim().isEmpty()) {
            Task selectedTask = listModel.getElementAt(selectedIndex);
            String modifiedTaskName = taskInput.getText().trim();
            selectedTask.setName(modifiedTaskName);
            listModel.setElementAt(selectedTask, selectedIndex);
            taskInput.setText("");
        }
    }
}

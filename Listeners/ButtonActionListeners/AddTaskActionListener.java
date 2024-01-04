package TodoList.Listeners.ButtonActionListeners;

import TodoList.Task;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddTaskActionListener implements ActionListener {
    private DefaultListModel<Task> listModel;
    private JTextField taskInput;

    public AddTaskActionListener(DefaultListModel<Task> listModel, JTextField taskInput) {
        this.listModel = listModel;
        this.taskInput = taskInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String taskName = taskInput.getText();
        if (!taskName.isEmpty()) {
            listModel.addElement(new Task(taskName, false));
            taskInput.setText("");
        }
    }
}

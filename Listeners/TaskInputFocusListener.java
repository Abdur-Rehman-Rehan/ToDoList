package TodoList.Listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class TaskInputFocusListener implements FocusListener {
    private JTextField taskInput;


    public TaskInputFocusListener(JTextField taskInput) {
        this.taskInput = taskInput;
;
    }

    @Override
    public void focusGained(FocusEvent e) {
        taskInput.setForeground(Color.white);
        taskInput.setBackground(Color.black);
    }

    @Override
    public void focusLost(FocusEvent e) {
        // taskInput.setForeground(textColor);
        taskInput.setBackground(new Color(0x2b2b2b));
    }
}

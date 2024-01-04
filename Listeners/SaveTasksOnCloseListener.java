package TodoList.Listeners;

import TodoList.Task;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.DefaultListModel;


public class SaveTasksOnCloseListener extends WindowAdapter {
    private DefaultListModel<Task> listModel;
    private File file;

    public SaveTasksOnCloseListener(DefaultListModel<Task> listModel, File file) {
        this.listModel = listModel;
        this.file = file;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < listModel.getSize(); i++) {
                Task task = listModel.getElementAt(i);
                writer.println(task.toString());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }
}

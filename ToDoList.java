package ToDoList;

import javax.swing.*;

public class ToDoList {
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI is created on the event dispatch thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(600, 400);

        
    }
}

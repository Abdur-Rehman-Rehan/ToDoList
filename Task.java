package TodoList;

public class Task {
    private String name;
    private boolean completed;

    public Task(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        // Include the completion status in the string representation
        return (completed ? "[x] " : "[ ] ") + name;
    }
}
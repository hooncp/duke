import java.time.format.DateTimeFormatter;

public class Task {
    protected String description;
    protected boolean isDone;
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean getDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }


    public String getStatusIcon() {
        return (isDone ? "+" : "-"); //return + symbols means done - symbol means not done
    }

    @Override
    public String toString() {
        String mark = "[" + getStatusIcon() + "] " + getDescription();
        return mark;
    }
    //...
}

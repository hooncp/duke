package duke.command;

import duke.*;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.InputMismatchException;
/**
 * Represents a command which adds duke.task.Task to the Tasklist.
 * @see TaskList
 * @see Task
 */
public class AddCommand extends Command {
    String[] commandSplit = super.stringCommand.split(" ");
    String deadline = "deadline";
    String event = "event";
    String todo = "todo";

    /**
     * Constructor for duke.command.AddCommand
     * @param stringCommand String representation of the user input
     */
    public AddCommand(String stringCommand) {
        super(stringCommand);
    }

    /**
     * Executes the command by using the three arguments provided
     * @param taskList
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task addTask;
        String outputString = "";
        if (commandSplit[0].equalsIgnoreCase(deadline)) {
            String details = super.stringCommand.substring(deadline.length()).trim();
            if (details.length() == 0) {
                throw new InputMismatchException("The description of a deadline cannot be empty.");
            }
            String[] detail = details.split(" /by ");
            addTask = new Deadline(detail[0], detail[1]);
            outputString = outputString + ui.printAddedMessage();
            outputString = outputString + ui.printTask(addTask);
            taskList.add(addTask);
        } else if (commandSplit[0].equalsIgnoreCase(event)) {
            String details = super.stringCommand.substring(event.length()).trim();
            if (details.length() == 0) {
                throw new InputMismatchException("The description of a event cannot be empty.");
            }
            String[] detail = details.split(" /at ");
            addTask = new Event(detail[0], detail[1]);
            outputString = outputString + ui.printAddedMessage();
            outputString = outputString + ui.printTask(addTask);
            taskList.add(addTask);
        } else if (commandSplit[0].equalsIgnoreCase(todo)) {
            String details = super.stringCommand.substring(todo.length()).trim();
            if (details.length() == 0) {
                throw new InputMismatchException("The description of a todo cannot be empty.");
            }
            addTask = new Todo(details);
            outputString = outputString + ui.printAddedMessage();
            outputString = outputString + ui.printTask(addTask);
            taskList.add(addTask);
        }
        outputString = outputString + ui.printNumberOfTasks(taskList);
        return outputString;
    }
}
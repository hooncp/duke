package duke.command;

import duke.Storage;
import duke.task.Task;
import duke.TaskList;
import duke.Ui;

import java.util.ArrayList;

/**
 * Represents a command which finds the Tasks in the Tasklist which contains the same use input String.
 * @see TaskList
 * @see Task
 */
public class FindCommand extends Command{
    private String findKeywork;

    /**
     * Constructor for duke.command.FindCommand
     * @param stringCommand String representation of the user input
     */
    public FindCommand(String stringCommand) {
        super(stringCommand);
        String[] stringSplit = stringCommand.split(" ");
        findKeywork = stringSplit[1];
    }

    /**
     * Executes the command by using the three arguments provided
     * @param taskList
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task t : taskList.getTasks()) {
            if (t.getDescription().contains(findKeywork)) {
                tasks.add(t);
            }
        }
        return ui.printFindMessage(tasks);
    }

    /**
     * Checks if Duke will end.
     * @return false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}

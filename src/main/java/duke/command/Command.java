package duke.command;

import duke.Storage;
import duke.task.Task;
import duke.TaskList;
import duke.Ui;

/**
 * Represents a command which has specific uses.
 * @see TaskList
 * @see Task
 * @see AddCommand
 * @see ByeCommand
 * @see DeleteCommand
 * @see DoneCommand
 * @see FindCommand
 * @see ListCommand
 */

public abstract class Command {
    String stringCommand;

    /**
     * Constructor for duke.command.ByeCommand
     * @param stringCommand String representation of the user input
     */
    public Command(String stringCommand) {
        this.stringCommand = stringCommand;
    }

    /**
     * Executes the command by using the three arguments provided and
     * Returns the String to be written.
     * @param taskList
     * @param ui
     * @param storage
     */
    public abstract String execute(TaskList taskList, Ui ui, Storage storage);

    /**
     * Checks if Duke will end.
     * @return false
     */
    public boolean isExit() {
        return false;
    }
}
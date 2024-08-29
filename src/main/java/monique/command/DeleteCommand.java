package monique.command;

import monique.exception.DeleteException;
import monique.storage.Storage;
import monique.task.Task;
import monique.tasklist.TaskList;
import monique.ui.Ui;

/**
 * Represents a command to delete a specific task from the task list.
 * The command identifies a task by its index and removes it from the task list.
 */
public class DeleteCommand extends Command {

    private final int taskNum;

    /**
     * Constructs a <code>DeleteCommand</code> with the specified task index.
     *
     * @param taskNum the index of the task to be deleted
     */
    public DeleteCommand(int taskNum) {
        super();
        this.taskNum = taskNum;
    }

    /**
     * Executes the delete command, which involves removing a task from the task list
     * and updating the user interface and storage accordingly.
     *
     * @param tasks the <code>TaskList</code> from which the task will be deleted
     * @param ui the <code>Ui</code> instance used for notifying the user
     * @param storage the <code>Storage</code> instance used for data persistence
     * @throws DeleteException if the task index is out of range or invalid
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DeleteException {
        if (this.taskNum > tasks.getNumItems() - 1 || this.taskNum < 0) {
            throw new DeleteException();
        }
        Task deletedTask = tasks.getTask(this.taskNum);
        tasks.deleteTask(this.taskNum);
        ui.deleteMessage(deletedTask, tasks);
    }

    /**
     * Returns whether this chatbot will be active after the command executes.
     * @return true since bot should remain active after delete commands
     */
    @Override
    public boolean isActive() {
        return true;
    }

    /**
     * Compares this <code>DeleteCommand</code> instance with another object for equality.
     * Two <code>DeleteCommand</code> instances are considered equal if their task numbers are the same.
     *
     * @param obj the object to be compared with this <code>DeleteCommand</code>
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the object is compared with itself
        if (this == obj) {
            return true;
        }

        // Check if the object is an instance of DeleteCommand
        if (obj instanceof DeleteCommand) {
            DeleteCommand other = (DeleteCommand) obj;
            // Compare taskNum of both objects
            return this.taskNum == other.taskNum;
        }

        // If obj is not an instance of DeleteCommand, return false
        return false;
    }


}




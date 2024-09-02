package monique.command;

import java.util.ArrayList;

import monique.storage.Storage;
import monique.task.Task;
import monique.tasklist.TaskList;
import monique.ui.Ui;


/**
 * Represents a command to find tasks in the task list based on a search key.
 * <p>
 * This command searches for tasks that contain a specified search key in their description
 * and provides the search results to the user interface.
 * </p>
 */
public class FindCommand extends Command {

    private final String searchKey;
    private String findResults = "";

    /**
     * Constructs a {@code FindCommand} with the specified search key.
     *
     * @param searchKey the key to search for in task descriptions
     */
    public FindCommand(String searchKey) {
        super();
        this.searchKey = searchKey;
    }

    /**
     * Executes the find command, searching for tasks that contain the search key
     * in their description and updating the UI with the results.
     *
     * @param tasks the task list to search through
     * @param ui the user interface for displaying search results
     * @param storage the storage used to save the tasks (not used in this method)
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        //create a new arrayList<Task> for UI to print through
        ArrayList<Task> resultList = new ArrayList<>();
        for (Task task: tasks.getTaskList()) {
            if (task.getDescription().contains(this.searchKey)) {
                resultList.add(task);
            }
        }
        this.findResults = ui.showFindResults(resultList);
    }

    /**
     * Returns whether the command is active.
     *
     * @return true, as the find command is always active
     */
    @Override
    public boolean isActive() {
        return true;
    }

    /**
     * Retrieves the response message from the find command execution.
     *
     * @param ui the user interface instance (not used in this method)
     * @return a string containing the results of the find operation
     */
    @Override
    public String getResponse(Ui ui) {
        return this.findResults;
    }
}

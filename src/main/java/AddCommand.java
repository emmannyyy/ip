public class AddCommand extends Command {

    private final Task task;

    public AddCommand(Task task){
        super();
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(this.task);
        ui.addMessage(this.task);
    }

    @Override
    public boolean isActive(){
        return true;
    }
}

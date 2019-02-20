import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    public List<Task> tasks;
    private int index;

    public TaskManager() {
        tasks = new ArrayList<Task>();
        index = 1;
    }

    public int getIndex()
    {
        return index;
    }

    // Adds a task to the task manager with the given id, name, description and date
    public void addTask(int index,
            String name, String description, String projectName, LocalDate date)
    {
        Task task = new Task(index, name, description, projectName);
        task.setDate(date);
        tasks.add(task);

        this.incrementIndex();
    }

    private void incrementIndex()
    {
        this.index++;
    }

    public void updateView ()
    {
        for(Task t : tasks)
        {
            t.displayTask();
        }
    }



    // getTaskById returns a Task with the given ID
    //getTaskById(int id)
    // iterate through tasks and find the right task and use t.getTaskName()
// (OPTIONAL) look if a task exists with the same _name_ AND _projectname_
    // If you enable this option, a boolean could be used as return value
    // if exists return false else true
}

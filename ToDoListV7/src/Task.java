import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {

    private String name;
    private String taskDescription;
    private String projectname;
    private int taskId;
    private boolean taskCompleted;
    private LocalDate taskCreation;
    private LocalDate completionDate;
    TaskView taskView = new TaskView();




    public Task(String description)
    {
        taskDescription = description;
        this.taskCompleted = false;
        taskCreation = LocalDate.now();
    }

    public Task() {
        this(0, null, null, null);
    }

    public Task(int id, String name, String description, String projectName)
    {
        this.taskId = id;
        this.name = name;
        this.taskDescription = description;
        this.projectname = projectName;
        taskDescription = description;
        this.taskCompleted = false;
        taskCreation = LocalDate.now();
        completionDate = null;
        taskView = new TaskView();

    }

    public void setDate(LocalDate date)
    {
        this.completionDate = date;
    }

    // getter for completition date

    public void setTaskName(String name)
    {
           this.name = name;
    }
    public String getTaskName()
    {
        return this.name;
    }
    public void setTaskDescription()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set a task description: ");
        taskDescription = sc.next();
    }
    public String getTaskDescription()
    {
        return this.taskDescription;
    }

    public boolean isTaskCompleted()
    {
        return this.taskCompleted;
    }

    public LocalDate getTaskCreation()
    {
        return this.taskCreation;
    }
   public int getTaskId()
    {
        return taskId;
    }

    public void displayTask()
    {
        TaskView.printTaskDetails(getTaskName(),getTaskDescription());
    }
}

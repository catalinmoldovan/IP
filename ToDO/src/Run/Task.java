package Run;

import Display.Prints;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


/**
 * A simple task class that provides the task parameters
 * and task attribute methods
 */

public class Task implements Comparable, Serializable
{
    private static final long serialVersionUID = 1L;
    private String taskName;
    private String project;
    private boolean isCompleted;
    private Date date;
    private String description;
    Prints prints = new Prints();

    /**
     * A task constructor calling parameter
     * methods for the task.
     */

    public Task()
    {
        setProject();
        setTaskName();
        setDate();
        isCompleted=false;
    }

    /**
     * Class constructor
     * @param title the name of the task.
     * @param project the name of the project.
     * @param date the date assigned to the tasks.
     */
    public Task(int title, int project, Date date)
    {
        taskName = Integer.toString(title);
        this.project = Integer.toString(project);
        this.date = date;
        isCompleted = false;
    }

    /**
     * Constructor for the task class
     * @param name a string that contains the task name.
     * @param project a string that contains the project name.
     * @param completed statement of task completion, i.e. true or false.
     */
    public Task(String name, String project, Boolean completed)
    {
        this.taskName = name;
        this.project = project;
        this.isCompleted = completed;
    }


    public String getProject()
    {
        return project;
    }

    /**
     * Method that modifies the name of
     * the projects.
     */

    public void setProject()
    {
        Scanner scn = new Scanner(System.in);
        System.out.print(">> Insert project name: \n");
        project = scn.nextLine();
        System.out.print(">> Project name is: " + project);
    }

    /**
     * Get method.
     * @return returns a task name.
     */
    public String getTaskName()
    {
        return taskName;
    }

    /**
     * Method that modifies the name of
     * the tasks.
     */

    public void setTaskName()
    {
        Scanner scn = new Scanner(System.in);
        System.out.print("\n >> Write task name: ");
        taskName = scn.nextLine();
        System.out.print("\n >> Task name is: " + taskName);
    }

    /**
     * Method that modifies the state
     * of the tasks from i.e. completed
     * or incomplete.
     */

    public void changeTaskStatus()
    {
        isCompleted = !isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Method that compares the tasks according to the date assigned.
     * @param t the task that is compared.
     * @return integer values to arrange the dates in order.
     */
    @Override
    public int compareTo(Object t)
    {
        if (date.after(((Task)t).date))
            return 1;
        if (date.equals(((Task)t).date))
            return 0;

        return -1;
    }

    /**
     * Method that configures how the task will be displayed.
     * @return the stream or the pattern of the task display.
     */
    @Override
    public String toString()
    {
        String s = ">>------------------------------------------------------------" +
                "\n" +
                ">>  <Project name>: " + project
                +   "\n>>  <Task name>: " + taskName
                +   "\n>>  <Due Date>: " + date
                +   "\n>>  <Completed>: " + isCompleted
                +   "\n>>  <Task Description>:" + description  + "\n"
                +   ">>============================================================"
                + "\n";
        return s;
    }


    /**
     * Method that modifies the task description
     */

    public void setDescription()
    {
        Scanner sc =new Scanner(System.in);

        System.out.println(">> Enter task description\n");
        description=sc.nextLine();
    }

    /**
     * Method that modifies the date of the task
     */

    public void setDate()
    {
        System.out.print("\n>> Write date of completion: (Please use \"dd.MM.yyyy \" format): ");
        Scanner scn = new Scanner(System.in);

        boolean success = false;

        do
        {
            try
            {
                date = new SimpleDateFormat("dd.MM.yyyy").parse(scn.nextLine());
                success=true;

            }   catch (ParseException e)
            {
                System.out.println(">> Please enter the date in the requested format");

            }
        }
        while(!success);
    }


    /**
     * Provides a submenu for the customisation of the task
     * by all known attributes after the task was selected.
     */

    public void editTask()
    {
        prints.editTaskByFactors();
        Scanner scanner = new Scanner(System.in);
        Integer editChoice = 0;
        Integer choices[]={1,2,3,4,5};

        while (!Arrays.asList(choices).contains(editChoice))
        {
            editChoice=scanner.nextInt();

            switch(editChoice)
            {
                case 1:
                    setTaskName();
                    System.out.println(">> Task was renamed\n");
                    editTask();
                    break;

                case 2:
                    setDate();
                    return;

                case 3:
                    setDescription();
                    editTask();
                    break;

                case 4:
                    setProject();
                    return;

                case 5:
                    return;

                default:
                    System.out.println(">> Please enter a valid option\n");

            }
        }

    }
}

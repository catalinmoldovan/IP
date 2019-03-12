import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Task implements Comparable, Serializable
{

    private static final long serialVersionUID = 1L;
    private String taskName;
    private String project;
    private boolean isCompleted;
    private Date date;
    Prints prints = new Prints();
    private String description;

    public Task()
    {
        setProject();
        setTaskName();
        setDate();
        isCompleted=false;
    }

    public Task(int title, int project, Date date)
    {
        taskName = Integer.toString(title);
        this.project = Integer.toString(project);
        this.date = date;
        isCompleted = false;
    }


    public String getProject()
    {
        return project;
    }

    public void setProject()
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Insert project name: ");
        project = scn.nextLine();
        System.out.println("project name is: " + project);
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName()
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Write task name: ");
        taskName = scn.nextLine();
        System.out.println("Task name is: " + taskName);
    }


    public void changeTaskStatus()
    {
        isCompleted = !isCompleted;
    }
    @Override

    public int compareTo(Object t)
    {
        if (date.after(((Task)t).date))
            return 1;
        if (date.equals(((Task)t).date))
            return 0;

        return -1;
    }

    public String toString()
    {
        String s = "Project name: " + project
                + "\t Task name: " + taskName
                + "\tDate: " + date
                + "\tCompleted: " + isCompleted + "\n";
        return s;
    }

    public Task(String name, String project, Boolean completed)
    {
        this.taskName = name;
        this.project = project;
        this.isCompleted = completed;
    }

    public void setDescription()
    {

        Scanner sc =new Scanner(System.in);

        System.out.println("Enter task description\n");
        description=sc.nextLine();
    }


    public void setDate()
    {
        System.out.print("Write date of completion: (Please use \"dd.MM.yyyy \" format): ");
        Scanner scn = new Scanner(System.in);

        boolean success=false;
        do
        {
            try
            {
                date = new SimpleDateFormat("dd.MM.yyyy").parse(scn.nextLine());
                success=true;

            }   catch (ParseException e)

            {
                System.out.println("Please enter the date in the requested format");
            }
        }
        while(!success);
    }

    public void editTask()
        {
            prints.editTaskByFactors();
            Scanner scanner = new Scanner(System.in);
            String editChoice=null;
            String choices[]={"N","T","D","R","P"};


            while (!Arrays.asList(choices).contains(editChoice))
            {
                editChoice=scanner.next();

                switch(editChoice)
                {
                    case "N":
                        System.out.println("Enter the new name:");
                        taskName = scanner.next();
                        System.out.println("Task was renamed");
                        break;

                    case "T":
                        setDate();
                        break;

                    case "D":

                        setDescription();
                        break;

                    case "P":

                        setProject();
                        break;

                    case "R":
                        return;

                    default:
                        System.out.println("Please enter a valid option\n");


                }
            }

        }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Provides a very simple ToDoList.  New items can be added at the end
 * and removed from any other position.
 *
 * @author CM
 */
public class ToDoList
{
    public ArrayList<Task> tasks=new ArrayList<>();
    private int index;
    Scanner scn = new Scanner(System.in);

    public void addTask()
    {

       String userEnteredTask = "";
       while (!userEnteredTask.equals("y"))
       {
           System.out.println("Do you want to add another task? Y / N");
           userEnteredTask = scn.nextLine().toLowerCase();
           
           if (userEnteredTask.equals("y"))
           {
               Task t = new Task();
               tasks.add(t);
               addTask();
           } if (userEnteredTask.equals("n"))
           {
               break;
           }
       }
    }

    public ArrayList<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks)
    {
        this.tasks = tasks;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public ToDoList()
    {
        tasks = new ArrayList();
        index = 0;
    }

/**
 * Adds the given item to this ToDoList.  Returns true if successfully
 * added, or false if not (such as when the list is full).
 */

    public boolean add(String task)
    {
        if (this.index == this.tasks.size())
        {
            return false;
        } else
            {
                this.tasks = new ArrayList<>(tasks);
                this.index++;
                return true;
            }
    }

/**
   * Returns how many items are currently stored in this list.
   */
      public int getIndex()
      {
          return index;
      }
/**
   * Removes the item at the given 1-based index in this list.
   * Returns the removed item, or null if the given index did not correspond
   * to a valid item.
   */

       public void removeTaskByName(String name)
       {
         Iterator<Task> it= tasks.iterator();
         while(it.hasNext())
         if(it.next().getTaskName().equals(name))
         it.remove();
       }

       public void removeTaskByProject(String project)
       {
         Iterator<Task> it = tasks.iterator();
         while(it.hasNext())
         if(it.next().getProject().equals(project))
         it.remove();
       }

         public String toString()
       {
           String output = "TODO:\n";
           for (int i = 0; i < tasks.size() ; i++ )
           {
               output += (i + 1) + ". " + tasks.size() + "\n";
           }
           return output;
       }

       public void showList()
       {
            if(tasks.size() > 0)
        {
            for(int index = 0; index < tasks.size(); index++)
            {
            System.out.printf("Index: %d Task: %s",index, tasks.get(index));
            }

        }   else
            {
            System.out.println("No tasks to display");
            }
       }
}







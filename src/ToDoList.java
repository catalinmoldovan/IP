import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

    /**
     * Provides a very simple ToDoList.  New items can be added at the end
     * and removed from any other position.
     *
     * @author CM
     */
    public class ToDoList implements Serializable
    {
        private static final long serialVersionUID = 1L;
        public ArrayList<Task> tasks;
        private Task activeTask = null;
        Prints prints = new Prints();
        private final int NUMBEROFTASKS = 10;
        private int index;
        private String project;
        Scanner scn = new Scanner(System.in);

        public void addTask()
        {
            Task t = new Task();
            tasks.add(t);
            String choice = "";

            do
            {
                System.out.println("Do you want to add another task? Y / N");
                choice = scn.nextLine().toLowerCase();

                switch (choice)
                {
                    case "y":
                        Task tsk = new Task();
                        tasks.add(tsk);
                    case "n":
                        break;

                    default:
                        System.out.println("Please choose a valid option.");
                        break;
                }
            }
            while (choice.equals("y"));
        }

        public ToDoList()
        {

            tasks = new ArrayList();
            index = 0;
        }
        /**
         * Adds the given item to this ToDoList.  Returns true if successfully
         * added, or false if not (such as when the list is full).
         *

        /**
         * Returns how many items are currently stored in this list.
         */

        public void showList()
        {
            if (tasks.size() == 0)
            {
                System.out.println("No tasks to display");
                return;
            } else {
                prints.showList();
                Scanner scn = new Scanner(System.in);

                int choice = scn.nextInt();

                while (choice < 1 && choice > 2)
                {
                    System.out.println("Please insert a valid choice.");
                    prints.showList();
                    choice = scn.nextInt();
                }
                switch (choice)
                {
                    case 1:
                        showByDate();
                        break;

                    case 2:
                        System.out.println(tasks);
                        filterByProject();
                        break;
                }
            }
        }

        public String toString(List<Task> tasks)
         {
            StringBuilder sb = new StringBuilder();
            for (Task t : tasks) {
                sb.append(t.toString());
            }
            return sb.toString();
         }

         public void editMenu()
         {
            prints.editTaskMenu();

            Scanner scn2 = new Scanner(System.in);

            int choice = scn2.nextInt();

            while (choice > 0 && choice < 5)
            {
                switch (choice)
                {
                    case 1:
                        selectTask();

                        activeTask.editTask();

                        break;

                    case 2:
                        removeTaskByName();
                        System.out.println("Task was removed.");
                        return;

                    case 3:
                        selectTask();
                        activeTask.changeTaskStatus();
                        System.out.println("Task status was changed.");
                        return;

                    case 4:
                        return;

                    default:
                        System.out.println("Please select a valid option: ");
                        editMenu();
                }


            }

        }

        public void selectTask()
        {

            activeTask = searchTask();

            while (activeTask == null)
            {
                activeTask = searchTask();
            }
            System.out.println("Task " + activeTask.getTaskName() + " was selected." );
        }

        public Task searchTask()
        {
            System.out.println("Insert task name: ");

            Scanner scn  = new Scanner(System.in);

            String taskName = scn.nextLine();
            for(Task t : tasks)
            {
                if (t.getTaskName().equals(taskName))
                    return t;
            }
            System.out.println("Task not found !");
            return null;
        }


        public void removeTaskByName()
        {
            Task t = searchTask();

            if (t == null)
            {
                System.out.println("Invalid name.");
                return;
            }
            tasks.remove(t);
            System.out.println( t.getTaskName() + " is removed.");
        }

        public void showByDate()
        {
            List<Task> tasksByDate = tasks
                    .stream()
                    .sorted(( a , b ) -> a.compareTo(b) )
                    .collect(Collectors.toList());
            System.out.println(this.toString(tasksByDate));
        }

        public void filterByProject()
        {
            System.out.println("Filter projects by name. ");
            System.out.println("Please insert name: ");
            Scanner scn  = new Scanner(System.in);


            String project = scn.nextLine();

            List<Task> projectTasks = tasks
                    .stream()
                    .filter(t -> t.getProject().equals(project))
                    .collect(Collectors.toList());
            if (projectTasks.size() == 0)
                System.out.println("No tasks are assigned to that project.");
            else
                System.out.println(this.toString(projectTasks));
        }


        public void loadList()
        {
            File file = new File("list.ser");
            if(!file.exists())
                return;

            FileInputStream fi;
            ObjectInputStream input = null;

            try
            {
                fi = new FileInputStream("list.ser");

                input = new ObjectInputStream(fi);
            } catch (IOException io)
            {
                System.out.println("File ERROR!");
            }
            try {
                tasks = (ArrayList<Task>) input.readObject();
            } catch (Exception e)
            {
                System.out.println("Read ERROR!");
            }
        }

        public void saveList() throws IOException
        {
            FileOutputStream fo = new FileOutputStream("list.ser");
            ObjectOutputStream output = new ObjectOutputStream(fo);
            output.writeObject(tasks);
        }

        public void setProject()
        {
            Scanner sc =new Scanner(System.in);
            System.out.println("Which project does it belong to?");
            project = sc.nextLine();

        }



        public void fillTestData()
        {
            Random rnd =new Random();

            for(int i=0;i<NUMBEROFTASKS;i++)
            {
                int year=rnd.nextInt(500)+2010;
                int month=rnd.nextInt(12)+1;
                int []day30={4,6,9,11};
                int []day31={1,3,5,7,8,10,12};
                int day;
                if(Arrays.asList(day30).contains(month))
                    day=rnd.nextInt(30)+1;
                else if(Arrays.asList(day31).contains(month))
                    day=rnd.nextInt(31)+1;
                else
                    day=rnd.nextInt(28)+1;

                int hour=rnd.nextInt(23)+1;
                int minute=rnd.nextInt(60+1);
                Date d=(new GregorianCalendar(year,month,day,hour,minute)).getTime();

                int title=rnd.nextInt(20)+1;
                int project=rnd.nextInt(5)+1;

                tasks.add(new Task(title,project,d));
            }
        }
    }

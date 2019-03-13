import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

    /**
     * @ToDOList class
     * Provides a very simple ToDoList.  New items can be added at the end
     * and removed from any other position.
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
        Scanner scn = new Scanner(System.in);

        /**
         * I love Russia. ?
         */
        public void addTask()
        {
            Task t = new Task();
            tasks.add(t);
            String choice = "";

            do
            {
                System.out.println(">> Do you want to add another task? Y / N");
                choice = scn.nextLine().toLowerCase();

                switch (choice)
                {
                    case "y":
                        Task tsk = new Task();
                        tasks.add(tsk);
                    case "n":
                        break;

                    default:
                        System.out.println(">> Please choose a valid option.");
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


        public void showList()
        {
            if (tasks.size() == 0)
            {
                System.out.println(">> No tasks to display");
                return;
            } else {
                prints.showList();
                Scanner scn = new Scanner(System.in);
                int choice = 1;

                try {
                    choice = scn.nextInt();
                } catch (InputMismatchException x)
                {
                    System.out.println(">> Please choose a valid option.");
                    showList();
                }
                while (choice < 1 && choice > 2)
                {
                    System.out.println(">> Please insert a valid choice.");
                    prints.showList();
                    choice = scn.nextInt();
                }
                switch (choice)
                {
                    case 1:
                        showByDate();
                        break;

                    case 2:
                        showByDate();
                        filterByProject();
                        break;
                }
            }
        }

        /**
         * @toString
         * A method that converts objects to String in order
         * to read the tasks and projects that where added
         */

        public String toString(List<Task> tasks)
         {
            StringBuilder sb = new StringBuilder();
            for (Task t : tasks) {
                sb.append(t.toString() + "\n");
            }
            return sb.toString();
         }

        /**
         * @editMenu
         * A submenu for the Edit task option of the Main menu
         * that calls methods that modify sed tasks by different
         * parameters
         */

        public void editMenu()
         {
            prints.editTaskMenu();
            int choice = 1;

            Scanner scn2 = new Scanner(System.in);

            try {
                choice = scn2.nextInt();
            } catch (InputMismatchException i)
            {
                System.out.println(">> Please choose a valid option.");
                editMenu();
            }

            while (choice > 0 && choice < 5)
            {
                switch (choice)
                {
                    case 1:
                        selectTask();
                        activeTask.editTask();
                        return;

                    case 2:
                        removeTaskByName();
                        System.out.println(">> Task was removed.");
                        return;

                    case 3:
                        selectTask();
                        activeTask.changeTaskStatus();
                        System.out.println(">> Task status was changed.");
                        return;

                    case 4:
                        return;

                    default:
                        System.out.println(">> Please select a valid option: ");
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
            System.out.println(">> Task " + activeTask.getTaskName() + " was selected." );
        }

        public Task searchTask()
        {
            System.out.println(tasks);
            System.out.println(">> Insert task name: ");

            Scanner scn  = new Scanner(System.in);

            String taskName = scn.nextLine();
            for(Task t : tasks)
            {
                if (t.getTaskName().equals(taskName))
                    return t;
            }
            System.out.println(">> Task not found !");
            return null;
        }

        public void removeTaskByName()
        {
            Task t = searchTask();

            if (t == null)
            {
                System.out.println(">> Invalid name.");
                return;
            }
            tasks.remove(t);
            System.out.println(">>Task " + t.getTaskName() + " is removed.");
        }

        /**
         * @showByDate
         * @filterByProject
         * Methods that filter the tasks according to
         * date and project name
         */

        public void showByDate()
        {
            List<Task> tasksByDate = tasks
                    .stream()
                    .sorted(( a , b ) -> a.compareTo(b) )
                    .collect(Collectors.toList());
            System.out.println(toString(tasksByDate));
        }

        public void filterByProject()
        {
            System.out.println(">> The are projects filtered by name. ");
            System.out.println(">> Please insert the project name: ");
            Scanner scn  = new Scanner(System.in);

            String project = scn.nextLine();

            List<Task> projectTasks = tasks
                    .stream()
                    .filter(t -> t.getProject().equals(project))
                    .sorted(( a , b ) -> a.compareTo(b) )
                    .collect(Collectors.toList());
            if (projectTasks.size() == 0)
                System.out.println(">> No tasks are assigned to that project.");
            else
                System.out.println(toString(projectTasks) );
        }


        /**
         * @loadList
         * A method that saves the current tasks on local
         * memory
         */

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
                System.out.println(">> File ERROR!");
            }
            try {
                tasks = (ArrayList<Task>) input.readObject();
            } catch (Exception e)
            {
                System.out.println(">> Read ERROR!");
            }
        }

        public void saveList() throws IOException
        {
            FileOutputStream fo = new FileOutputStream("list.ser");
            ObjectOutputStream output = new ObjectOutputStream(fo);
            output.writeObject(tasks);
        }

        /**
         * @countCompleted
         * @countOpen
         * Methods that count the total number of tasks and that
         * stream the ones that are completed and the ones that are
         * not in order to print them in the welcome menu.
         */

        public long countCompleted()
        {
            long x = tasks.stream().filter(t->t.isCompleted()).count();
            return x;
        }

        public long countOpen()
        {
            long y = tasks.stream().filter(u->!u.isCompleted()).count();
            return y;
        }


        /**
         * @fillTestData
         * A method hidden from the user which provides a series of
         * random tasks, projects, dates, etc. used to test the program.
         */

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

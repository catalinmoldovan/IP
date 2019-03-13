import java.io.Serializable;

/**
 * A print out class that contains all the menus that are
 * printed out in order to provide quick and easy access
 * to modification with the scope of reducing code lines.
 */

public class Prints implements Serializable
{

    public void mainMenu()
    {
        System.out.print(
            "  >> (1) Show Task List (by date or project)\n"
          + "   >> (2) Add New Task \n"
          + "    >> (3) Edit Task (update, remove, mark as done ) \n"
          + "     >> (4) Save and Quit \n"
          + "      >> Pick an option: \n"
          + "      >>");
    }

    public void showList()
    {
        System.out.println(">> (1) Show tasks by date: ");
        System.out.println(" >> (2) Show tasks by project: ");
    }

    public void editTaskMenu()
    {
        System.out.println(">> Please chose a option: \n"
               + ">> (1) for Update\n"
               + " >> (2) for Delete\n"
               + "  >> (3) for marking as Completed\n"
               + "   >> (4) to return to the previous menu\n");
    }

    public void editTaskByFactors()
    {
        System.out.println("What do you want to change?\n"
               + ">> (1) for Task name\n"
               + " >> (2) for Task date\n"
               + "  >> (3) for Task description\n"
               + "   >> (4) for Task name\n"
               + "    >> (5) to Return to the previous menu\n");
    }
}

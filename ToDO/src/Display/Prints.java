package Display;

import java.io.Serializable;

/**
 * A print out class that contains all the menus that are
 * printed out in order to provide quick and easy access
 * to modification with the scope of reducing code lines.
 */

public class Prints implements Serializable
{

    /**
     * Method the prints out the main menu,
     * and the first menu that the user sees.
     */
    public void mainMenu()
    {
        System.out.print(
                ">> Pick an option:\n"
                + "  >> (1) Display Task List (by date or project)\n"
                        + "   >> (2) Add New Task \n"
                        + "    >> (3) Edit Task (update, remove, mark as done ) \n"
                        + "     >> (4) Save and Quit \n"
                        + "      >> Pick an option: \n"
                        + "      >>");
    }

    /**
     * Method that prints out the menu that the uses sees
     * at the list changes
     */
    public void showList()
    {
        System.out.println(">> (1) Show tasks by date: ");
        System.out.println(" >> (2) Show tasks by project: ");
    }

    /**
     * Method that prints out the submenu from the edit task
     * option in the Main Menu
     */
    public void editTaskMenu()
    {
        System.out.println(">> Please chose a option: \n"
                + ">> (1) for Update\n"
                + " >> (2) for Delete\n"
                + "  >> (3) for marking as Completed\n"
                + "   >> (4) to return to the previous menu\n");
    }

    /**
     * Method that prints out the submenu from the Update option
     * in the Edit Task Menu
     */
    public void editTaskByFactors()
    {
        System.out.println("What do you want to change?\n"
                + ">> (1) for Task name\n"
                + " >> (2) for Task date\n"
                + "  >> (3) for Task description\n"
                + "   >> (4) for Project name\n"
                + "    >> (5) to Return to the previous menu\n");
    }
}

import java.io.Serializable;

public class Prints implements Serializable
{

    public void mainMenu()
    {
        System.out.println("MENU:");
        System.out.println("1 - Show Task List");
        System.out.println("2 - Add new task");
        System.out.println("3 - Edit Task");
        System.out.println("4 - Save and quit");
        System.out.println("5. test");
        System.out.print("Enter your menu choice: ");
    }


    public void updateMenu()
    {
        System.out.println("1. Update name: ");
        System.out.println("2. Update date: ");
        System.out.println("3. Update project name: ");
    }

    public void showList()
    {
        System.out.println("1. Show tasks by date: ");
        System.out.println("2. Show tasks by project: ");
    }

    public void editTaskMenu()
    {
        System.out.println("Please chose a option: \n" +
                "(1) for Update\n" +
                "(2) for Delete\n" +
                "(3) for marking as Completed\n" +
                "(4) to return to the previous menu\n");
    }

    public void editTaskByFactors()
    {
        System.out.println("What do you want to change?\n" +
                "(N) for Name\n" +
                "(T) for Time and Date\n" +
                "(D) for Description\n" +
                "(P) for Project\n" +
                "(R) to Return to the previous menu\n");
    }
}

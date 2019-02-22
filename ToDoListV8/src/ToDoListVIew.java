import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListVIew
{
    ToDoList toDoList = new ToDoList();

    public static void main(String[] args)
    {
        ToDoListVIew toDoListVIew = new ToDoListVIew();
        toDoListVIew.showMenu();

    }

    public void showMenu()
    {
        int choice = 1;
        Scanner scn = new Scanner(System.in);
        {
            System.out.println();
                //System.out.println(toDoList);
            System.out.println("MENU:");
            System.out.println("1 - Show Task List");
            System.out.println("2 - Add new task");
            System.out.println("3 - Edit Task");
            System.out.println("4 - Save and quit");
            System.out.print("Enter your menu choice: ");

            String userEnteredTask;

            choice = scn.nextInt();
            scn.nextLine();
            switch(choice)
            {
                case 1:
                    toDoList.showList();
                    break;
                case 2:
                    toDoList.addTask();
                    showMenu();
                case 3:

                case 4:
            }

        }
    }
}




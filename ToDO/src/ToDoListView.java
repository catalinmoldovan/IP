import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoListView
{
    ToDoList toDoList = new ToDoList();
    Prints prints = new Prints();



    public static void main(String[] args)
    {
        ToDoListView toDoListVIew = new ToDoListView();
        toDoListVIew.toDoList.loadList();
        toDoListVIew.count();
        toDoListVIew.mainMenu();
    }

    public void count()
    {
        System.out.println(" >> Welcome to ToDoLy \n "
                + ">> You have " + toDoList.countOpen()
                + " tasks todo and " + toDoList.countCompleted()
                +" tasks is/are done!");
    }

    public void mainMenu()
    {
        int choice = 1;
        Scanner scn = new Scanner(System.in);

        prints.mainMenu();

        try {
            choice = scn.nextInt();
        } catch (InputMismatchException i)
        {
            System.out.println("Please insert a number.");
            mainMenu();
        }

        switch (choice)
        {
            case 1:
                toDoList.showList();
                mainMenu();
                break;

            case 2:
                toDoList.addTask();
                mainMenu();
                break;

            case 3:
                toDoList.editMenu();
                mainMenu();
                break;

            case 4:

                try {
                    toDoList.saveList();
                } catch (IOException i) {
                    System.out.println("Write ERROR!");
                }
                break;

            case 9:
                toDoList.fillTestData();
                mainMenu();
                break;

            default:
                mainMenu();
        }
    }
}




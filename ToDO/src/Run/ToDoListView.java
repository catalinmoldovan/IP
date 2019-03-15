package Run;

import Display.Prints;

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

    /**
     * Method that displays the tasks, separating them
     * in completed and incomplete
     */
    public void count()
    {
        System.out.println(" >> Welcome to ToDoLy \n "
                + ">> You have " + toDoList.countOpen()
                + " tasks todo and " + toDoList.countCompleted()
                +" tasks is/are done!");
    }

    /**
     * Method that displays a initial menu for the user,
     * providing the user manual options
     */
    public void mainMenu()
    {
        int choice = 1;
        Scanner scn = new Scanner(System.in);

        prints.mainMenu();

        try {
            choice = scn.nextInt();
        } catch (InputMismatchException i)
        {
            System.out.println(">> Please insert a valid option: \n");
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
                toDoList.testCases();
                mainMenu();
                break;

            default:
                mainMenu();
        }
    }
}




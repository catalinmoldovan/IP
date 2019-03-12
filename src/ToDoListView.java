import java.io.IOException;
import java.util.Scanner;

public class ToDoListView
{
    ToDoList toDoList = new ToDoList();
    Prints prints = new Prints();


    public static void main(String[] args)
    {
        ToDoListView toDoListVIew = new ToDoListView();
        toDoListVIew.toDoList.loadList();
        toDoListVIew.mainMenu();

    }

    public void mainMenu()
    {
        int choice = 1;
        Scanner scn = new Scanner(System.in);

            prints.mainMenu();

            choice = scn.nextInt();

            //scn.nextLine();

            switch(choice)
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
                    //prints.editTaskMenu();
                    toDoList.editMenu();
                    mainMenu();
                    break;

                case 4:

                    try
                    {
                        toDoList.saveList();
                    } catch (IOException i)
                    {
                        System.out.println("Write ERROR!");
                    }
                    break;

                case 5:
                    toDoList.fillTestData();
                    mainMenu();
                    break;

                default:
                    mainMenu();
            }


    }
}




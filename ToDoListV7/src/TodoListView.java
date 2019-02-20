import java.util.Scanner;

public class TodoListView {

    Scanner scanner = new Scanner(System.in);

    public TodoListView()
    {

    }
    // show welcome msg

    // show main options

    // GetUserInput(scanner in)

    int GetUserInputInteger()
    {
        int input = -1;
        while (this.scanner.hasNext()) {
            // catch exception for input that is not an int
            // otherwise, it will crash
            input = this.scanner.nextInt();
            this.scanner.nextLine();
            break;
        }
        return input;
    }

    // Get string from user input
    String GetUserInputString()
    {
        String in = "";
        while (this.scanner.hasNext())
        {
            in = this.scanner.nextLine();
            break;
        }
        return in;
    }

    // is it really a date? parse string to date

    //create all the loops for the menu options in here


}

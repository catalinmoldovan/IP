import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Task name = retrieveTaskFromDatabase();
        TaskView taskView = new TaskView();
        Scanner sc = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();

        taskManager.updateView();

    }

    private static Task retrieveTaskFromDatabase() {
        Task task = new Task("");
        task.setTaskName("shaworma");
        task.setTaskDescription();
        return task;

    }


}

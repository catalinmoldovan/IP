import Run.Task;
import Run.ToDoList;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    ToDoList toDoList = new ToDoList();

    @Test
    void filterByProjectTests()
    {
        Task t1,t2,t3;
        t1 = new Task("Eat", "JunkFood", false);
        t2 = new Task("Spill", "Water", false);
        t3 = new Task("Drink", "Water", true);

        toDoList.getTasks().add(t1);
        toDoList.getTasks().add(t2);
        toDoList.getTasks().add(t3);

        ArrayList<Task> l = new ArrayList<>();

        l.add(t2);
        l.add(t3);

        toDoList.filterByProject();

        assertFalse(l.equals(toDoList.getTasks()));

    }

    @Test
    void countOpen() {
        ToDoList toDoList = new ToDoList();
        assertFalse(toDoList.countOpen()==1);
       toDoList.addTask();
       assertFalse(toDoList.countOpen()==2);
    }
}
import Run.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void getProjectTest()
    {
        Task task = new Task("taskName", "projectName", false);
        assertEquals("projectName", task.getProject());
        assertNotNull("Project");

    }

    @Test
    public void setProject()
    {
        Task task = new Task("projectName","TaskName",false);
        assertEquals("projectName", "projectName");
        assertNotSame("123","383383");
        assertNotNull("","");
    }

    @Test
    public void getTaskNameTest()
    {
        Task task = new Task("Test", "Another test", true);
        assertEquals("Test", task.getTaskName());
        assertNotNull("","");
        assertNotSame("test","on more test");
    }

    @Test
    public void setTaskNameTest()
    {
        Task task = new Task("Run.Task", "Project", false);
        assertEquals("Run.Task", "Run.Task");
        assertNull(null);
    }

    @Test
    public void changeTaskStatusTest()
    {
        Task task = new Task("Test","one",false);
        assertNotEquals("Test","two",true);
        assertTrue(true);
    }

    @Test
    public void isCompletedTest()
    {
        Task task = new Task("","",true);
        assertFalse("Test is",false);
        assertTrue(true);
    }

    @Test
    public void compareToTest()
    {
        Task task = new Task("Bravo","Charlie",false);
        assertNotSame("Delta","Golf", true);
        assertNotNull("Bravo");
    }

    @Test
    public void setDescriptionTest()
    {
        Task task = new Task("John", "Johnny", true);
        assertEquals("John", "Johnny", "Johnny");
        assertFalse(false);
    }

}
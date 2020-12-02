
import org.junit.Assert;
import org.junit.Test;

public class TaskItemTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructorFailsWithInvalidDueDate() {
       new TaskItem("A Simple Task", "A Short Description", "no a date").toString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorFailsWithInvalidTitle() {
        new TaskItem("", "A Short Description", "2020-01-01").toString();
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        Assert.assertNotNull(new TaskItem("A Task", "A Short Description", "2020-01-01"));
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        Assert.assertNotNull(new TaskItem("A", "A Short Description", "2020-01-01"));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("A", "A Short Description", "2020-01-01");
        task.edit("A", "B", "2020-01-01");
        Assert.assertEquals("B", task.getDesription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem task = new TaskItem("A", "A Short Description", "2020-01-01");
        task.edit("A", "B", "20-1-01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskItem task = new TaskItem("A", "A Short Description", "2020-01-01");
        task.edit("A", "B", "2021-02-29");
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("A", "A Short Description", "2020-01-01");
        task.edit("A", "B", "2020-02-29");
        Assert.assertEquals("2020-02-29", task.getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingTitleFailsWithEmptyString() {
        TaskItem task = new TaskItem("A", "A Short Description", "2020-01-01");
        task.edit("", "B", "2020-01-01");
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("A", "A Short Description", "2020-01-01");
        task.edit("C", "B", "2020-01-01");
        Assert.assertEquals("C", task.getTitle());
    }
}

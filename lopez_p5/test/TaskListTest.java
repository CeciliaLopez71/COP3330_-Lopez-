
import org.junit.Assert;
import org.junit.Test;

public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize() {
        TaskList taskList = new TaskList();
        int startSize = taskList.getTasks().size();
        taskList.addTask(new TaskItem());

        int newSize = taskList.getTasks().size();
        Assert.assertEquals(startSize + 1, newSize);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem();
        taskList.addTask(task);

        Assert.assertFalse(task.isComplete());
        taskList.markTaskAsCompleted(0);
        Assert.assertTrue(task.isComplete());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        Assert.assertFalse(taskList.markTaskAsCompleted(0));
        Assert.assertFalse(taskList.markTaskAsCompleted(1));
        Assert.assertFalse(taskList.markTaskAsCompleted(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));
        taskList.editTask(1, "Title", "Description", "2020-10-10");
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));
        taskList.editTask(0, "Title", "Description", "2020-10-10");
        Assert.assertEquals("Description", taskList.getTask(0).getDesription());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));
        taskList.editTask(0, "Title", "Description", "2020-10-10");
        Assert.assertEquals("2020-10-10", taskList.getTask(0).getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingItemTitleFailsWithEmptyString() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));
        taskList.editTask(0, "", "Description", "2020-10-10");
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));

        boolean illegalArgument = false;

        try {
            taskList.editTask(1, "AAA", "Description", "2020-10-10");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            illegalArgument = true;
        }

        Assert.assertTrue(illegalArgument);
        Assert.assertEquals("A", taskList.getTask(0).getTitle());
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));
        taskList.editTask(0, "AAA", "Description", "2020-10-10");
        Assert.assertEquals("AAA", taskList.getTask(0).getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));

        boolean illegalArgument = false;

        try {
            taskList.editTask(1, "AAA", "Description", "2020-10-10");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            illegalArgument = true;
        }

        Assert.assertTrue(illegalArgument);
        Assert.assertEquals("A", taskList.getTask(0).getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));

        boolean illegalArgument = false;

        try {
            taskList.editTask(1, "AAA", "Description", "2020-10-10");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            illegalArgument = true;
        }

        Assert.assertTrue(illegalArgument);
        Assert.assertEquals("2000-10-10", taskList.getTask(0).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("A", "B", "2000-10-10"));

        boolean illegalArgument = false;

        try {
            taskList.editTask(1, "AAA", "Description", "2021-02-29");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            illegalArgument = true;
        }

        Assert.assertTrue(illegalArgument);
        Assert.assertEquals("2000-10-10", taskList.getTask(0).getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("Title", "Description", "2020-10-10"));
        Assert.assertEquals("Description", taskList.getItemDueDate(1));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("Title", "Description", "2020-10-10"));
        taskList.getItemDescription(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("Title", "Description", "2020-10-10"));
        taskList.getItemDueDate(1);
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
                TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("Title", "Description", "2020-10-10"));
        Assert.assertEquals("2020-10-10", taskList.getItemDueDate(0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("Title", "Description", "2020-10-10"));
        taskList.getItemTitle(1);
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem("Title", "Description", "2020-10-10"));
        Assert.assertEquals("Title", taskList.getItemTitle(0));
    }

    @Test
    public void newListIsEmpty() {
        TaskList taskList = new TaskList();
        int startSize = taskList.getTasks().size();
        Assert.assertEquals(0, startSize);
    }

    @Test
    public void removingItemsDecreasesSize() {
        TaskList taskList = new TaskList();
        taskList.addTask(new TaskItem());
        int startSize = taskList.getTasks().size();
        Assert.assertTrue(taskList.remove(0));
        int newSize = taskList.getTasks().size();
        Assert.assertEquals(startSize - 1, newSize);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        Assert.assertFalse(taskList.remove(0));
        Assert.assertFalse(taskList.remove(-1));
        Assert.assertFalse(taskList.remove(1));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList taskList = new TaskList();
        boolean storeResult = taskList.storeToFile("testTasks.txt");
        Assert.assertTrue(storeResult);

        taskList.addTask(createTestTask());
        taskList.addTask(createTestTask());
        taskList.addTask(createTestTask());

        boolean loadResult = taskList.storeToFile("testTasks.txt");
        Assert.assertTrue(loadResult);
    }

    private TaskItem createTestTask() {
        TaskItem task = new TaskItem();
        task.setTitle("Test Title");
        task.setDescription("Test Description");
        task.setDate("2020-11-11");
        return task;
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem();
        task.setMarked(true);
        taskList.addTask(task);

        Assert.assertTrue(task.isComplete());
        taskList.markTaskAsIncomplete(0);
        Assert.assertFalse(task.isComplete());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        Assert.assertFalse(taskList.markTaskAsIncomplete(0));
        Assert.assertFalse(taskList.markTaskAsIncomplete(1));
        Assert.assertFalse(taskList.markTaskAsIncomplete(-1));
    }
}

package main.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TaskListTest {

    @Test
    void addingTaskItemsIncreasesSize() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);

        assertEquals(taskList.getTaskList().size(), 1);
    }

    @Test
    void completingTaskItemChangesStatus() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertTrue(taskList.getTaskList().get(0).isCompleted());
    }

    @Test
    void completingTaskItemFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertThrows(Exception.class, () -> {
            taskList.editItemTaskList(10, "test", "test", "2020-12-12", false);
        });
    }

    @Test
    void editingTaskItemChangesValues() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        taskList.editItemTaskList(0, "test2", "test2", "2020-12-12", false);
        assertEquals(taskList.getTaskList().get(0).getDescription(), "test2");
        assertEquals(taskList.getTaskList().get(0).getTitle(), "test2");
    }

    @Test
    void editingTaskItemDescriptionChangesValue() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        taskList.editItemTaskList(0, "test", "test2", "2020-12-12", false);
        assertEquals(taskList.getTaskList().get(0).getDescription(), "test2");
    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        taskList.editItemTaskList(0, "test", "test2", "2020-12-22", false);
        assertThrows(Exception.class, () -> {
            taskList.editItemTaskList(12, "test", "test222", "2020-12-12", false);
        });
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertThrows(Exception.class, () -> {
            taskList.editItemTaskList(12, "test", "test", "2020-12-12", false);
        });
    }

    @Test
    void editingTaskItemTitleChangesValue() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        taskList.editItemTaskList(0, "test2", "test2", "2020-12-22", false);
        assertEquals(taskList.getTaskList().get(0).getTitle(), "test2");
    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertThrows(Exception.class, () -> {
            taskList.editItemTaskList(2, "test", "test", "2020-12-12", false);
        });
    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        taskList.editItemTaskList(0, "test2", "test2", "2020-12-12", false);
        assertEquals(taskList.getTaskList().get(0).getDescription(), "test2");
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        assertThrows(Exception.class, () -> {
            taskList.getTaskList().get(2).getDescription();
        });
    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertEquals(taskList.getTaskList().get(0).getDueDate(), "2020-12-12");
    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertThrows(Exception.class, () -> {
            taskList.getTaskList().get(2).getDueDate();
        });
    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);

        assertEquals(taskList.getTaskList().get(0).getTitle(), "test");
    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addItemToTaskList(taskItem);
        taskList.getTaskList().get(0).setCompleted(true);
        assertThrows(Exception.class, () -> {
            taskList.editItemTaskList(2, "test", "test", "2020-12-12", false);
        });
    }

}

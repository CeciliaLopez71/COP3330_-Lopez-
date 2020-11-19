package main.java;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.TaskItem;
import org.junit.jupiter.api.Test;

class TaskItemTest {

    @Test
    void creatingTaskItemFailsWithInvalidDueDate() {

        assertThrows(Exception.class, () -> {
            new TaskItem("test", "test", "sss", false);
        });

    }

    @Test
    void creatingTaskItemFailsWithInvalidTitle() {

        assertThrows(Exception.class, () -> {
            new TaskItem("", "test", "2020-12-12", false);
        });

    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate() throws Exception {


        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        taskItem.setDueDate("2020-11-11");
        assertEquals(taskItem.getDueDate(), "2020-11-11");

    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle() {

        assertThrows(Exception.class, () -> {
            new TaskItem("test", "test", "12-12-12", false);
        });

    }

    @Test
    void settingTaskItemDueDateFailsWithInvalidDate() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);

        assertThrows(Exception.class, () -> {
            taskItem.setDueDate("32");
        });

    }

    @Test
    void settingTaskItemDueDateSucceedsWithValidDate() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);
        taskItem.setDueDate("2020-11-11");
        assertEquals(taskItem.getDueDate(), "2020-11-11");

    }

    @Test
    void settingTaskItemTitleFailsWithInvalidTitle() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);

        assertThrows(Exception.class, () -> {
            taskItem.getTitle();
        });

    }

    @Test
    void settingTaskItemTitleSucceedsWithValidTitle() throws Exception {

        TaskItem taskItem = new TaskItem("test", "test", "2020-12-12", false);

        taskItem.setTitle("test123");

        assertEquals(taskItem.getTitle(), "test123");

    }
}

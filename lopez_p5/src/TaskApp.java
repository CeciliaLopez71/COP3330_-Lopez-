

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class TaskApp extends AbstractApp {

    private static final int MAIN_MENU_NEW_LIST = 1;
    private static final int MAIN_MENU_LOAD_LIST = 2;
    private static final int MAIN_MENU_QUIT = 3;

    private static final int LIST_OP_VIEW = 1;
    private static final int LIST_OP_ADD = 2;
    private static final int LIST_OP_EDIT = 3;
    private static final int LIST_OP_REM = 4;
    private static final int LIST_OP_MARK = 5;
    private static final int LIST_OP_UNMARK = 6;
    private static final int LIST_OP_SAVE = 7;
    private static final int LIST_OP_QUIT = 8;

    TaskList taskList;

    public TaskApp(BufferedReader _reader) {
        super(_reader);
        this.taskList = null;
    }

    @Override
    public void startProgramm() throws IOException {

        printWelcome();

        while (true) {
            int menuSelection = readPositiveNumber();
            if (menuSelection < 1 || menuSelection > 6) {
                System.out.println(INVALID_SELECTION);
                continue;
            }

            if (menuSelection == MAIN_MENU_NEW_LIST) {
                createNewList();
            }

            if (menuSelection == MAIN_MENU_LOAD_LIST) {
                loadList();
            }

            if (menuSelection == MAIN_MENU_QUIT) {
                // return to main program
                break;
            }

            printWelcome();
        }
    }

    private void printWelcome() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
    }

    private void printListMenu() {
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an list");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }

    private void enterListMenu() throws IOException {
        printListMenu();

        while (true) {
            int menuSelection = readPositiveNumber();
            if (menuSelection < 1 || menuSelection > 8) {
                System.out.println(INVALID_SELECTION);
                continue;
            }

            if (menuSelection == LIST_OP_VIEW) {
                printTaskList(true, true);
            }

            if (menuSelection == LIST_OP_ADD) {
                addTask();
            }

            if (menuSelection == LIST_OP_EDIT) {
                editTask();
            }

            if (menuSelection == LIST_OP_REM) {
                removeTask();
            }

            if (menuSelection == LIST_OP_MARK) {
                markTask();
            }

            if (menuSelection == LIST_OP_UNMARK) {
                unmarkTask();
            }

            if (menuSelection == LIST_OP_SAVE) {
                saveTask();
            }

            if (menuSelection == LIST_OP_QUIT) {
                break;
            }

            printListMenu();
        }
    }

    private void loadList() throws IOException {
        this.taskList = new TaskList();

        System.out.println("Enter the filename to load:");
        String filename = readFilename();
        boolean result = this.taskList.loadFromFile(filename);

        if (result) {
            System.out.println("task list has been loaded");
        } else {
            System.out.println("an error occured when loading the task list");
        }

        enterListMenu();
    }

    private void createNewList() throws IOException {
        System.out.println("new task list has been created");
        this.taskList = new TaskList();
        enterListMenu();
    }

    private void printTaskList(boolean printMarkedTasks, boolean printUnmarkedTasks) {

        String listTitle = "";

        if (printMarkedTasks == false) {
            listTitle = "Uncompleted Tasks";
        }

        if (printUnmarkedTasks == false) {
            listTitle = "Completed Tasks";
        }

        if (printMarkedTasks == printUnmarkedTasks) {
            listTitle = "Current Tasks";
        }

        System.out.println(listTitle);
        System.out.println("-------------");

        List<TaskItem> tasks = this.taskList.getTasks();

        String taskFormat = "%d) %s[%s] %s: %s";

        int taskIndex = 0;

        for (TaskItem item : tasks) {

            if (item.isComplete() & !printMarkedTasks) {
                continue;
            }

            if (!item.isComplete() & !printUnmarkedTasks) {
                continue;
            }

            String date = item.getDate();
            String title = item.getTitle();
            String desc = item.getDesription();

            String marker = item.isComplete() ? "*** " : "";
            
            String task = String.format(taskFormat, taskIndex, marker, date, title, desc);
            System.out.println(task);
            ++taskIndex;
        }
    }

    private void addTask() throws IOException {
        TaskItem taskItem = new TaskItem();

        System.out.println("Task title:");
        String taskTitle = readTitle();
        taskItem.setTitle(taskTitle);

        System.out.println("Task description:");
        String taskDescription = readDescription();
        taskItem.setDescription(taskDescription);

        System.out.println("Task due date (YYYY-MM-DD):");
        String taskDate = readDate();
        taskItem.setDate(taskDate);

        this.taskList.addTask(taskItem);
    }

    private void editTask() throws IOException {
        printTaskList(true, true);
        System.out.println("");
        System.out.println("Which task will you edit?");

        int selection = readPositiveNumber();
        TaskItem currentItem = this.taskList.getTask(selection);

        if (currentItem == null) {
            System.out.println(INVALID_SELECTION);
            return;
        }

        String line1 = "Enter a new title for task %d:";
        System.out.println(String.format(line1, selection));
        String title = readTitle();
        currentItem.setTitle(title);

        String line2 = "Enter a new description for task %d:";
        System.out.println(String.format(line2, selection));
        String description = readDescription();
        currentItem.setDescription(description);

        String line3 = "Enter a new task due date (YYYY-MM-DD) for task %d:";
        System.out.println(String.format(line3, selection));
        String date = readDate();
        currentItem.setDate(date);
    }

    private void removeTask() throws IOException {
        printTaskList(true, true);
        System.out.println("");
        System.out.println("Which task will you remove?");

        int selection = readPositiveNumber();
        boolean result = this.taskList.remove(selection);

        if (result == false) {
            System.out.println(INVALID_SELECTION);
        }
    }

    private void markTask() throws IOException {
        printTaskList(false, true);
        System.out.println("");
        System.out.println("Which task will you mark as completed?");
        int selection = readPositiveNumber();
        boolean result = this.taskList.markTaskAsCompleted(selection);

        if (result == false) {
            System.out.println(INVALID_SELECTION);
        }

    }

    private void unmarkTask() throws IOException {
        printTaskList(true, false);
        System.out.println("");
        System.out.println("Which task will you unmark as completed?");
        int selection = readPositiveNumber();
        boolean result = this.taskList.markTaskAsIncomplete(selection);

        if (result == false) {
            System.out.println(INVALID_SELECTION);
        }
    }

    private void saveTask() throws IOException {
        System.out.println("Enter the filename to save as:");
        String filename = readFilename();

        boolean result = this.taskList.storeToFile(filename);

        if (result) {
            System.out.println("task list has been saved");
        } else {
            System.out.println("task list has not been saved");
        }
    }

    private String readDescription() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = TaskItem.isValidDescription(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid Description!");
        }
    }

    private String readTitle() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = TaskItem.isValidTitle(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid Title!");
        }
    }

    private String readDate() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = TaskItem.isValidDate(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid Date!");
        }
    }
}

package main.java;
import java.util.*;
import java.io.*;

public class App {

    public static void mainMenuPrints(){
        String mainMenu = "Main Menu\n" +
                "---------\n\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit";
        System.out.println(mainMenu);

    }

    public static void CreateNewListMenu(){
        String listMenu = "List Operation Menu\n" +
                "---------\n\n"+
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) un mark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu";
        System.out.println(listMenu);

    }

    public static void main(String[] args) {

        List<TaskItem> taskItemList=new ArrayList<TaskItem>();
        TaskList taskList = new TaskList(taskItemList);

        TaskItem taskItem=null;
        try {
            taskItem = new TaskItem("test", "test", "2020-12-12", false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        taskList.addItemToTaskList(taskItem);
        taskList.saveTaskList("objects_task.txt");

        taskList.loadCurrentTaskList("objects_task.txt");
        taskList.viewTaskList();

    }
}

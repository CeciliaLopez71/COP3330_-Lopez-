package main.java;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class TaskList implements Serializable { //will mark java classes & covert to be written into a file

    /**
     *
     */
    private static final long serialVersionUID = 1L; //

    private List<TaskItem> taskList;

    public TaskList(List<TaskItem> taskList) {

        this.taskList = taskList;
    }

    public TaskList() {
        
    }

    public List<TaskItem> getTaskList() {

        return taskList;
    }

    public void setTaskList(List<TaskItem> taskList) {

        this.taskList = taskList;
    }

    public void viewTaskList() {

        taskList.stream().forEach(task -> System.out.println(task.toString()));
    }

    public void saveTaskList(String filepath) {

        FileStorageManager.saveFile(taskList, filepath);
    }

    public void loadCurrentTaskList(String filepath) {

        this.taskList = FileStorageManager.loadFile(filepath);
    }

    public void addItemToTaskList(TaskItem taskItem) {

        this.taskList.add(taskItem);

    }

    public void editItemTaskList(int index, String title, String description, String dueDate, boolean isCompleted) throws Exception {

        Scanner scanner = new Scanner(System.in);
        if (index < this.taskList.size()) {
            TaskItem task = taskList.get(index);
            boolean isValid=task.validateString(title);
            if(isValid) {
                task.setTitle(title);
            }else {
                scanner.close();
                throw new Exception();
            }

            isValid=task.validateString(description);
            if(isValid) {
                task.setDescription(description);
            }else {
                scanner.close();
                throw new Exception();
            }

            isValid=task.isValidDate(dueDate);
            if(isValid) {
                task.setTitle(title);
            }else {
                scanner.close();
                throw new Exception();
            }

            task.setCompleted(isCompleted);

        } else {
            scanner.close();
            throw new Exception();
        }

        scanner.close();
    }

    public void markItemComplete(int index) {
        if (index < this.taskList.size()) {
            this.taskList.get(index).setCompleted(true);

        } else {
            System.out.println("Invalid index entered");
        }
    }

    public void unmarkItemComplete(int index) {
        if (index < this.taskList.size()) {
            this.taskList.get(index).setCompleted(false);

        } else {
            System.out.println("Invalid index entered");
        }
    }

    public void removeItemComplete(int index) {
        if (index < this.taskList.size()) {
            this.taskList.remove(index);

        } else {
            System.out.println("Invalid index entered");
        }
    }

    public void editItemTaskList(TaskItem taskItem, int taskIndex) {
    }
}

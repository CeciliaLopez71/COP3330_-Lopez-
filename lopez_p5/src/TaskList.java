
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TaskList {

    private final List<TaskItem> tasks;

    public TaskList() {
        this.tasks = new LinkedList<>();
    }

    void addTask(TaskItem taskItem) {
        this.tasks.add(taskItem);
    }

    List<TaskItem> getTasks() {
        return this.tasks;
    }

    boolean remove(int selection) {
        TaskItem task = getTask(selection);

        if (task == null) {
            return false;
        }

        return tasks.remove(task);
    }

    TaskItem getTask(int selection) {
        if (selection < 0 || selection >= this.tasks.size()) {
            return null;
        }
        return this.tasks.get(selection);
    }


    boolean markTaskAsCompleted(int index) {
        int completedTaskIndex = 0;
        for (TaskItem currentTask : this.tasks) {
            if (currentTask.isComplete()) {
                continue;
            }

            if (completedTaskIndex == index) {
                currentTask.setMarked(true);
                return true;
            }

            ++completedTaskIndex;
        }
        return false;
    }


    boolean markTaskAsIncomplete(int index) {
        int incompleteTaskIndex = 0;
        for (TaskItem currentTask : this.tasks) {
            if (currentTask.isComplete() == false) {
                continue;
            }

            if (incompleteTaskIndex == index) {
                currentTask.setMarked(false);
                return true;
            }

            ++incompleteTaskIndex;
        }
        return false;
    }

    boolean loadFromFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return false;
        }

        try (FileReader fileReader = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fileReader);) {

            while (reader.ready()) {
                TaskItem task = new TaskItem();
                task.setTitle(reader.readLine());

                if (reader.ready() == false) {
                    return false;
                }

                task.setDescription(reader.readLine());

                if (reader.ready() == false) {
                    return false;
                }

                task.setDate(reader.readLine());

                if (reader.ready() == false) {
                    return false;
                }

                task.setMarked("1".equals(reader.readLine()));

                tasks.add(task);
            }

        } catch (IOException ex) {
            return false;
        }

        return true;
    }

    boolean storeToFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return false;
        }

        try (FileWriter fileWriter = new FileWriter(filename);
                BufferedWriter writer = new BufferedWriter(fileWriter);) {
            for (TaskItem currentTask : this.tasks) {
                writer.write(currentTask.getTitle());
                writer.newLine();
                writer.write(currentTask.getDesription());
                writer.newLine();
                writer.write(currentTask.getDate());
                writer.newLine();
                writer.write(currentTask.isComplete() ? "1" : "0");
                writer.newLine();
            }
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
    
    public void editTask(int index, String _title, String _description, String _date)
    {
        TaskItem task = getTask(index);
        
        if (task == null)
        {
            throw new IllegalArgumentException("Index not found!");
        }
        
        task.edit(_title, _description, _date);
    }

    String getItemTitle(int index) {
        TaskItem task = getTask(index);
        
        if (task == null)
        {
            throw new IllegalArgumentException("Index not found!");
        }
        
        return task.getTitle();
    }

    String getItemDueDate(int index) {
        TaskItem task = getTask(index);
        
        if (task == null)
        {
            throw new IllegalArgumentException("Index not found!");
        }
        
        return task.getDate();
    }

    String getItemDescription(int index) {
        TaskItem task = getTask(index);
        
        if (task == null)
        {
            throw new IllegalArgumentException("Index not found!");
        }
        
        return task.getDesription();
    }
}

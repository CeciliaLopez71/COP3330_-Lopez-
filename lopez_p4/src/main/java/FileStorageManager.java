package main.java;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class FileStorageManager {

    public static void saveFile(List<TaskItem> taskList, String filepath) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskList);
            objectOut.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static List<TaskItem> loadFile(String filepath) {
        List<TaskItem> readObjects = null;
        try {
            FileInputStream fileInp = new FileInputStream(filepath);
            ObjectInputStream objectInp = new ObjectInputStream(fileInp);
            readObjects = (List<TaskItem>) objectInp.readObject();
            objectInp.close();
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return readObjects;
    }
}


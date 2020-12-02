

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {  
    public static void main(String[] args) throws IOException
    {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        try (BufferedReader reader = new BufferedReader(inputStream)) {
            new LauncherApp(reader).startProgramm();
        }
        catch (Exception e)
        {
            System.out.println("An error occured. The program will be terminated");
        }      
    }
}

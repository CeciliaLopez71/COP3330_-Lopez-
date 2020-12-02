

import java.io.BufferedReader;
import java.io.IOException;

public class LauncherApp extends AbstractApp {
    
    private static final int APP_TASK_LIST = 1;
    private static final int APP_CONTACT_LIST = 2;
    private static final int APP_QUIT = 3;

    public LauncherApp(BufferedReader _reader) {
        super(_reader);
    }

    private static void printWelcome() {
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
    }

    @Override
    public void startProgramm() throws IOException{
        printWelcome();

        while (true) {
            int menuSelection = readPositiveNumber();

            if (menuSelection < 1 || menuSelection > 3) {
                System.out.println(INVALID_SELECTION);
                continue;
            }

            if (menuSelection == APP_TASK_LIST) {
                new TaskApp(reader).startProgramm();
            }

            if (menuSelection == APP_CONTACT_LIST) {
                new ContactApp(reader).startProgramm();
            }

            if (menuSelection == APP_QUIT) {
                break;
            }
            printWelcome();
        }
    }
}

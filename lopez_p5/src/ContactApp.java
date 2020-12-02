

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ContactApp extends AbstractApp {

    private static final int MAIN_MENU_NEW_LIST = 1;
    private static final int MAIN_MENU_LOAD_LIST = 2;
    private static final int MAIN_MENU_QUIT = 3;

    private static final int LIST_OP_VIEW = 1;
    private static final int LIST_OP_ADD = 2;
    private static final int LIST_OP_EDIT = 3;
    private static final int LIST_OP_REM = 4;
    private static final int LIST_OP_SAVE = 5;
    private static final int LIST_OP_QUIT = 6;

    ContactList contactList;

    public ContactApp(BufferedReader _reader) {
        super(_reader);
        this.contactList = null;
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
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }

    void enterListMenu() throws IOException {
        printListMenu();

        while (true) {
            int menuSelection = readPositiveNumber();
            if (menuSelection < 1 || menuSelection > 6) {
                System.out.println(INVALID_SELECTION);
                continue;
            }

            if (menuSelection == LIST_OP_VIEW) {
                printContactList();
            }

            if (menuSelection == LIST_OP_ADD) {
                addContact();
            }

            if (menuSelection == LIST_OP_EDIT) {
                editContact();
            }

            if (menuSelection == LIST_OP_REM) {
                removeContact();
            }

            if (menuSelection == LIST_OP_SAVE) {
                saveContactList();
            }

            if (menuSelection == LIST_OP_QUIT) {
                break;
            }

            printListMenu(); // print when returning from sub section
        }
    }

    @Override
    public void startProgramm() throws IOException {
        printWelcome();

        while (true) {
            int menuSelection = readPositiveNumber();
            if (menuSelection < 1 || menuSelection > 3) {
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

    private void loadList() throws IOException {
        System.out.println("Enter the filename to load: ");
        String filename = readFilename();

        this.contactList = new ContactList();
        boolean successful = this.contactList.loadFromFile(filename);

        if (successful) {
            System.out.println("contact list has been loaded");
        } else {
            System.out.println("an error occured when loading the contact list");
        }

        enterListMenu();
    }

    private void createNewList() throws IOException {
        this.contactList = new ContactList();
        System.out.println("new contact list has been created");
        enterListMenu();
    }

    private void printContactList() {
        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println("");

        List<ContactItem> contactItemList = this.contactList.getContacts();

        String line1 = "%d) Name: %s %s";
        String line2 = "Phone: %s";
        String line3 = "Email: %s";

        for (int i = 0; i < contactItemList.size(); ++i) {
            ContactItem currentItem = contactItemList.get(i);
            System.out.println(String.format(line1, i, currentItem.getFirstName(), currentItem.getLastName()));
            System.out.println(String.format(line2, currentItem.getPhoneNumber()));
            System.out.println(String.format(line3, currentItem.getEmail()));
        }
    }

    private void addContact() throws IOException {
        ContactItem newContact = new ContactItem();

        System.out.println("First name:");
        String firstName = readFirstName();
        newContact.setFirstName(firstName);

        System.out.println("Last name:");
        String lastName = readLastName();
        newContact.setLastName(lastName);

        System.out.println("Phone number (xxx-xxx-xxxx):");
        String phoneNumber = readPhoneNumber();
        newContact.setPhoneNumber(phoneNumber);

        System.out.println("Email address (x@y.z):");
        String email = readEmail();
        newContact.setEmail(email);

        contactList.addContact(newContact);
    }

    private void editContact() throws IOException {
        printContactList();
        System.out.println("");
        System.out.println("");
        System.out.println("Which contact will you edit?");
        int contactNumber = readPositiveNumber();
        ContactItem contactToEdit = this.contactList.getContact(contactNumber);

        if (contactToEdit == null) {
            System.out.println(INVALID_SELECTION);
            return;
        }

        String line1 = "Enter a new first name for contact %d:";
        System.out.println(String.format(line1, contactNumber));
        String firstName = readFirstName();
        contactToEdit.setFirstName(firstName);

        String line2 = "Enter a new first name for contact %d:";
        System.out.println(String.format(line2, contactNumber));
        String lastName = readLastName();
        contactToEdit.setLastName(lastName);

        String line3 = "Enter a new phone number (xxx-xxx-xxxx) for contact %d:";
        System.out.println(String.format(line3, contactNumber));
        String phoneNumber = readPhoneNumber();
        contactToEdit.setPhoneNumber(phoneNumber);

        String line4 = "Enter a new email address (x@y.z) for contact %d:";
        System.out.println(String.format(line4, contactNumber));
        String email = readEmail();
        contactToEdit.setEmail(email);
    }

    private void removeContact() throws IOException {
        printContactList();
        System.out.println("");
        System.out.println("");
        System.out.println("Which contact will you remove?");

        int contactNumber = this.readPositiveNumber();
        boolean result = this.contactList.removeContact(contactNumber);

        if (result == false) {
            System.out.println(INVALID_SELECTION);
        }
    }

    private void saveContactList() throws IOException {
        System.out.println("Enter the filename to save as: ");
        String fileName = readFilename();
        boolean successful = this.contactList.storeToFile(fileName);

        if (successful) {
            System.out.println("task list has been saved");
        } else {
            System.out.println("task list has not been saved");
        }
    }

    private String readFirstName() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = ContactItem.isValidFirstName(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid First Name!");
        }
    }
    
    private String readLastName() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = ContactItem.isValidLastName(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid Last Name!");
        }
    }

    private String readPhoneNumber() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = ContactItem.isValidPhoneNumber(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid Phone Number!");
        }
    }

    private String readEmail() throws IOException {
        while (true) {
            String readLine = reader.readLine();
            boolean result = ContactItem.isValidEmail(readLine);

            if (result) {
                return readLine;
            }

            System.out.println("Invalid E-Mail!");
        }
    }
}

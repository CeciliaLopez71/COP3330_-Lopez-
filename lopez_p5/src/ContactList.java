

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ContactList {

    final List<ContactItem> contacts;

    public ContactList() {
        this.contacts = new LinkedList<>();
    }

    void addContact(ContactItem newContact) {
        this.contacts.add(newContact);
    }

    boolean removeContact(int contactIndex) {

        ContactItem contact = getContact(contactIndex);

        if (contact == null) {
            return false;
        }

        this.contacts.remove(contact);
        return true;
    }

    List<ContactItem> getContacts() {
        return this.contacts;
    }

    ContactItem getContact(int contactIndex) {

        if (contactIndex < 0 || contactIndex >= this.contacts.size()) {
            return null;
        }

        return this.contacts.get(contactIndex);
    }

    boolean loadFromFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return false;
        }

        try (FileReader fileReader = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fileReader);) {

            while (reader.ready()) {
                ContactItem contact = new ContactItem();
                contact.setFirstName(reader.readLine());

                if (reader.ready() == false) {
                    return false;
                }

                contact.setLastName(reader.readLine());

                if (reader.ready() == false) {
                    return false;
                }

                contact.setEmail(reader.readLine());

                if (reader.ready() == false) {
                    return false;
                }

                contact.setPhoneNumber(reader.readLine());
                this.contacts.add(contact);
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
            for (ContactItem currentContact : this.contacts) {
                writer.write(currentContact.getFirstName());
                writer.newLine();
                writer.write(currentContact.getLastName());
                writer.newLine();
                writer.write(currentContact.getEmail());
                writer.newLine();
                writer.write(currentContact.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException ex) {
            return false;
        }

        return true;
    }

    void edit(int index, String _firstName, String _lastName, String _email, String _phone) {
        ContactItem contact = getContact(index);
        
        if (contact == null)
        {
            throw new IllegalArgumentException("Invalid Index!");
        }
        
        contact.edit(_firstName, _lastName, _email, _phone);
    }
}

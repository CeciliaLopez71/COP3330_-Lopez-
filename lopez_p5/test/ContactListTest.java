

import org.junit.Assert;
import org.junit.Test;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList contactList = new ContactList();
        int startSize = contactList.getContacts().size();
        contactList.addContact(new ContactItem());

        int newSize = contactList.getContacts().size();
        Assert.assertEquals(startSize + 1, newSize);

    }

    @Test(expected = IllegalArgumentException.class)
    public void editingItemsFailsWithAllBlankValues() {
        ContactList contactList = new ContactList();
        contactList.addContact(createContactItem());
        contactList.edit(0, "", "", "", "");          
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingItemsFailsWithInvalidIndex() {
        ContactList contactList = new ContactList();
        contactList.addContact(createContactItem());
        contactList.edit(2, "John", "Doe", "john@doe.de", "123-123-1234");       
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList contactList = new ContactList();
        contactList.addContact(createContactItem());
        contactList.edit(0, "", "Doe", "john@doe.de", "123-123-1234");  
        Assert.assertTrue(contactList.getContact(0).getFirstName().isEmpty());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contactList = new ContactList();
        contactList.addContact(createContactItem());
        contactList.edit(0, "John", "", "john@doe.de", "123-123-1234");  
        Assert.assertTrue(contactList.getContact(0).getLastName().isEmpty());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contactList = new ContactList();
        contactList.addContact(createContactItem());
        contactList.edit(0, "John", "Doe", "", "123-123-1234");  
        Assert.assertTrue(contactList.getContact(0).getEmail().isEmpty());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList contactList = new ContactList();
        contactList.addContact(createContactItem());
        contactList.edit(0, "John", "Doe", "john@doe.de", "");  
        Assert.assertTrue(contactList.getContact(0).getPhoneNumber().isEmpty());
    }

    @Test
    public void newListIsEmpty() {
        ContactList cl = new ContactList();
        int startSize = cl.getContacts().size();
        Assert.assertEquals(0, startSize);
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList contactList = new ContactList();
        contactList.addContact(new ContactItem());
        contactList.addContact(new ContactItem());
        contactList.addContact(new ContactItem());

        int startSize = contactList.getContacts().size();
        boolean result = contactList.removeContact(0);

        Assert.assertTrue(result);
        Assert.assertEquals(startSize - 1, contactList.getContacts().size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList contactList = new ContactList();
        contactList.addContact(new ContactItem());
        contactList.addContact(new ContactItem());
        contactList.addContact(new ContactItem());

        boolean result3 = contactList.removeContact(3);
        Assert.assertFalse(result3);

        boolean result17 = contactList.removeContact(17);
        Assert.assertFalse(result17);

        boolean resultNegative2 = contactList.removeContact(-2);
        Assert.assertFalse(resultNegative2);
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList contactList = new ContactList();
        boolean storeResult = contactList.storeToFile("testContacts.txt");
        Assert.assertTrue(storeResult);

        contactList.addContact(createContactItem());
        contactList.addContact(createContactItem());
        contactList.addContact(createContactItem());
        
        boolean loadResult = contactList.storeToFile("testContacts.txt");
        Assert.assertTrue(loadResult);
    }

    private ContactItem createContactItem() {
        ContactItem contactItem = new ContactItem();
        contactItem.setFirstName("John");
        contactItem.setLastName("Smith");
        contactItem.setEmail("a@bc.de");
        contactItem.setPhoneNumber("123-456-1234");
        return contactItem;
    }

}

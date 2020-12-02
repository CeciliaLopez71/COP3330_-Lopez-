
import org.junit.Assert;
import org.junit.Test;

public class ContactItemTest {

    @Test(expected = IllegalArgumentException.class)
    public void creationFailsWithAllBlankValues() {
        new ContactItem("", "", "", "").toString();
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        Assert.assertNotNull(new ContactItem("John", "Doe", "", "123-123-1234"));
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        Assert.assertNotNull(new ContactItem("John", "", "john@doe.com", "123-123-1234"));
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        Assert.assertNotNull(new ContactItem("John", "Doe", "john@doe.com", ""));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        Assert.assertNotNull(new ContactItem("John", "Doe", "john@doe.com", "123-123-1234"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void editingFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("John", "Doe", "john@doe.com", "123-123-1234");
        item.edit("", "", "", "");
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("John", "Doe", "john@doe.com", "123-123-1234");
        item.edit("John", "Doe", "", "123-123-1234");
        Assert.assertTrue(item.getEmail().isEmpty());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("John", "Doe", "john@doe.com", "123-123-1234");
        item.edit("", "Doe", "john@doe.com", "123-123-1234");
        Assert.assertTrue(item.getFirstName().isEmpty());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("John", "Doe", "john@doe.com", "123-123-1234");
        item.edit("John", "", "john@doe.com", "123-123-1234");
        Assert.assertTrue(item.getLastName().isEmpty());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("John", "Doe", "john@doe.com", "123-123-1234");
        item.edit("John", "Doe", "john@doe.com", "");
        Assert.assertTrue(item.getPhoneNumber().isEmpty());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("John", "Doe", "john@doe.com", "123-123-1234");

        String newFirstName = "Jane";
        String newLastName = "Dawn";
        String newEmail = "jane@dawn.de";
        String newPhone = "999-999-9999";

        item.edit(newFirstName, newLastName, newEmail, newPhone);
        Assert.assertEquals(newFirstName, item.getFirstName());
        Assert.assertEquals(newLastName, item.getLastName());
        Assert.assertEquals(newEmail, item.getEmail());
        Assert.assertEquals(newPhone, item.getPhoneNumber());
    }

    @Test
    public void testToString() {
        ContactItem contact = new ContactItem();
        Assert.assertNotNull(contact.toString());
        Assert.assertFalse(contact.toString().isEmpty());
    }
}

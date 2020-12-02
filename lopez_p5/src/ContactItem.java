

public class ContactItem {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public ContactItem() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
    }
    
    public ContactItem(String _firstName, String _lastName, String _email, String _phoneNumer) {               
        editImpl(_firstName, _lastName, _email, _phoneNumer);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this.phoneNumber = _phoneNumber;
    }

    public static boolean isValidLastName(String readLine) {
        return true;
    }

    public static boolean isValidFirstName(String readLine) {
        return true;
    }

    // xxx-xxx-xxxx or empty
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            return true;
        }

        String[] numberSplit = phoneNumber.split("-");

        if (numberSplit.length != 3
                || numberSplit[0].length() != 3
                || numberSplit[1].length() != 3
                || numberSplit[2].length() != 4) {
            return false;
        }

        try {
            int part1 = Integer.valueOf(numberSplit[0]);
            int part2 = Integer.valueOf(numberSplit[1]);
            int part3 = Integer.valueOf(numberSplit[2]);

            if (part1 < 0 || part2 < 0 || part3 < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    // x@y.z or empty
    public static boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            return true;
        }

        String[] emailSplit = email.split("@");

        if (emailSplit.length != 2
                || emailSplit[0].length() == 0
                || emailSplit[1].length() < 3) {
            return false;
        }

        String[] domainSplit = emailSplit[1].split("\\.");

        boolean invalidDomain = domainSplit.length != 2
                || domainSplit[0].length() == 0
                || domainSplit[1].length() == 0;

        return !invalidDomain;
    }
    
    public void edit(String _firstName, String _lastName, String _email, String _phoneNumer)
    {
        editImpl(_firstName, _lastName, _email, _phoneNumer);
    }
    
    private void editImpl(String _firstName, String _lastName, String _email, String _phoneNumer)
    {
        if (!isValidFirstName(_firstName))
        {
            throw new IllegalArgumentException("Invalid First Name!");
        }

        if (!isValidLastName(_lastName))
        {
            throw new IllegalArgumentException("Invalid Last Name!");
        }

        if (!isValidEmail(_email))
        {
            throw new IllegalArgumentException("Invalid E-Mail!");
        }

        if (!isValidPhoneNumber(_phoneNumer))
        {
            throw new IllegalArgumentException("Invalid Phone Number!");
        } 
        
        boolean allBlank = _firstName.isEmpty() 
                && _lastName.isEmpty()
                && _email.isEmpty()
                && _phoneNumer.isEmpty();
        
        if (allBlank)
        {
            throw new IllegalArgumentException("Contact is Invalid!");
        }
        
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.phoneNumber = _phoneNumer;
    }
}

public class Encrypter {

    public String encrypt(String number) {
        // Converting char to integer
        int fourth = Character.getNumericValue(number.charAt(0));
        int third = Character.getNumericValue(number.charAt(1));
        int second = Character.getNumericValue(number.charAt(2));
        int first = Character.getNumericValue(number.charAt(3));

        //System.out.println(fourth);


        // Math
        int a = add_seven(fourth);
        int new_fourth = mod_ten(a);

        int b = add_seven(third);
        int new_third = mod_ten(b);

        int c = add_seven(second);
        int new_second = mod_ten(c);

        int d = add_seven(first);
        int new_first = mod_ten(d);

        // converting integer to char
        char pos4 = Character.forDigit(new_fourth, 10);
        char pos3 = Character.forDigit(new_third, 10);
        char pos2 = Character.forDigit(new_second, 10);
        char pos1 = Character.forDigit(new_first, 10);

        // Adding chars to string in order
        String stringy = "";
        stringy = stringy + pos2;
        stringy = stringy + pos1;
        stringy = stringy + pos4;
        stringy = stringy + pos3;

        //System.out.println("THIS IS MY Stringy!!!!: "+ stringy);

        return stringy;
    }

    //Helper Functions for adding and remainder
    public static int add_seven(int number) {
        int res = number + 7;

        return res;
    }

    public static int mod_ten(int number) {
        int res = number % 10;

        return res;
    }
}
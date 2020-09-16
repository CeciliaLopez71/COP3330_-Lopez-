import java.math.*;
public class Decrypter {

    public String decrypt(String number){

        int fourth = Character.getNumericValue(number.charAt(0));
        int third = Character.getNumericValue(number.charAt(1));
        int second = Character.getNumericValue(number.charAt(2));
        int first = Character.getNumericValue(number.charAt(3));


        // Math
        int a = subtract_seven(fourth);
        int new_fourth = modInverse_ten(a);

        int b = subtract_seven(third);
        int new_third = modInverse_ten(b);

        int c = subtract_seven(second);
        int new_second = modInverse_ten(c);

        int d = subtract_seven(first);
        int new_first = modInverse_ten(d);


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

    //Helper Functions for subtracting
    public static int subtract_seven(int number)
    {
        int res = number -7;

        return res;
    }

    public static int modInverse_ten(int number)
    {
        int res = number +10;

        if(res>=10)
            res = res -10;

        //System.out.println(res);
        return res;
    }



}












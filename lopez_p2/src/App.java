import java.util.*;
import java.lang.*;
public class App {


    public static void main(String[] args) {

        //moreInput();
        //getUserHeight();
        //getUserWeight();

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {


            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){

        Scanner s = new Scanner(System.in); //create scanner object
        System.out.println("Enter Y for figuring out your BMI or N for No,exit");
        char a = s.next().charAt(0);

        if (a == 'Y'){
            s.nextLine();
            return true;
        }else if(a == 'N') {
            s.nextLine();
            return false;
        }

        return false;

    }

    public static double getUserHeight()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Input height in inches: ");
        double height = s.nextDouble();
        while ( height < 0){
            System.out.println("Input Positive height please.");

            height = s.nextDouble();
        }

    return height;
    }

    public static double getUserWeight()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Input weight in lbs: ");
        double weight = s.nextDouble();
        while ( weight < 0){
            System.out.println("Input positive weight please.");

            weight = s.nextDouble();
        }
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi)
    {
        bmi.categorize();
        return;
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){

        double total = 0;
        double length = bmiData.size();
        double avg;

        for(BodyMassIndex bmi:bmiData)
        {

            total = total + bmi.getBMI();

        }

        avg = total / length;
        System.out.println("The average is: "+ avg);



    }




}

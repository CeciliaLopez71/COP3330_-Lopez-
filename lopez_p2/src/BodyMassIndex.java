import java.lang.Math;

public class BodyMassIndex {
    
    double weight;
    double height;
    //something goes here

    public BodyMassIndex(double height, double weight)
    {
        //what are variables?
        //assign variables

        this.weight = weight;
        this.height = height;

    }
    // BodyMassIndex(70, 150)
    // weight = 150
    // height = 7

    public double getBMI(){

        double bmi = (703 * weight)/ (Math.pow(height, 2));
        //703 * pounds / inches^2

        return bmi;
    }
    //Underweight < 18.5
    //Normal weight = 18.5–24.9
    //Overweight = 25–29.9
    //Obesity >= 30

    public  void categorize(){

        double data = getBMI();

        if( data < 18.5){
            System.out.println("Underweight");
        }
        else if ( data >= 18.5 && data <= 24.9){
            System.out.println("Normal Weight");
        }
        else if( data >= 25 && data <= 29.9){
            System.out.println("Overweight");
        }
        else if( data >= 30){
            System.out.println("Obese");
        }

        System.out.println("Your BMI is: " + data );
    }
    

}

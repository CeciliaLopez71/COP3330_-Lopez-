public class Circle extends Shape2D{


    private double radius;


    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double getArea() {

        return 3.1416*radius*radius;
    }

    @Override
    public String getName() {

        return "circle";
    }

}


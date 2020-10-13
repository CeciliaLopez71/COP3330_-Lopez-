
public class Square extends Shape2D{

    private double sideLength;

    public Square(double sideLength) {

        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength*sideLength;
    }

    @Override
    public String getName() {

        return "square";
    }

}

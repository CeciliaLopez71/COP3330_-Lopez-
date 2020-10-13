
public class Pyramid extends Shape3D{

    private double Length;
    private double Width;
    private double Height;
    private double result1;
    private double result2;


    public Pyramid(double length, double width, double height) {

        this.Length = length;
        this.Width = width;
        this.Height = height;
        this.result1 = (Length * Width) + Length * Math.sqrt(Math.pow((Width/2.00),2) + Math.pow(Height,2)) + Width * Math.sqrt(Math.pow((Length/2.00),2) + Math.pow(Height,2));
        this.result2 = (Length * Width * Height) / 3;

    }

    @Override
    public String getName() {

        return "pyramid";
    }
    @Override
    public double getVolume() {

        return result2;
    }

        @Override
    public double getArea() {
        return result1;
    }

}

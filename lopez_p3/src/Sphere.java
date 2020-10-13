
public class Sphere extends Shape3D{

    private double radius;

    public Sphere(double radius) {

        this.radius = radius;
    }

    @Override
    public double getVolume() {

        double area = 4.0/3.0;
        area = area*Math.PI;
        area = (area)*radius*radius*radius;


        return area;
    }

    @Override
    public String getName() {

        return "sphere";
    }

    @Override
    public double getArea() {

        return  4*3.1416*radius*radius;
    }

}

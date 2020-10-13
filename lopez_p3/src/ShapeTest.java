
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ShapeTest {

    // 3 test cases for square
    @Test
    void testSquareName() {

        Shape shape = new Square(10);
        assertEquals("square", shape.getName());

    }

    @Test
    void testSquareArea() {

        Shape2D shape = new Square(10);
        assertEquals(100, shape.getArea());

    }

    @Test
    void testSquareArea2() {

        Shape shape = new Square(0.5);
        assertEquals(0.25, shape.getArea());

    }

    // 3 test cases for triangle
    @Test
    void testTriangleName() {
        Shape shape = new Triangle(100, 100);
        assertEquals("triangle", shape.getName());
    }

    @Test
    void testTriangleArea() {
        Shape shape = new Triangle(10, 10);
        assertEquals(50, shape.getArea());
    }

    @Test
    void testTriangleArea2() {
        Shape shape = new Triangle(0.5, 0.25);
        assertEquals(0.063, shape.getArea(), 0.001);
    }

    // 3 test cases for circle
    @Test
    void testCircleName() {
        Shape shape = new Circle(10);
        assertEquals("circle", shape.getName());
    }

    @Test
    void testCircleArea() {
        Shape shape = new Circle(10);
        assertEquals(314.16, shape.getArea(), 0.01);
    }

    @Test
    void testCircleArea2() {
        Shape shape = new Circle(0.5);
        assertEquals(0.79, shape.getArea(), 0.01);
    }

    // 6 test cases for sphere
    @Test
    void testSphereName() {
        Shape shape = new Sphere(10);
        assertEquals("sphere", shape.getName());
    }

    @Test
    void testSphereArea() {
        Shape shape = new Sphere(10);
        assertEquals(1256.64, shape.getArea(), 0.01);
    }

    @Test
    void testSphereArea2() {
        Shape shape = new Sphere(0.75);
        assertEquals(7.07, shape.getArea(), 0.01);
    }

    @Test
    void testSphereVolume() {
        Shape3D shape = new Sphere(10);
        assertEquals(4188.79, shape.getVolume(), 0.1);
    }

    @Test
    void testSphereVolume2() {
        Shape3D shape = new Sphere(0.6);
        assertEquals(0.9, shape.getVolume(), 0.1);
    }

    // 6 test cases for cube
    @Test
    void testCubeName() {
        Shape shape = new Cube(100);
        assertEquals("cube", shape.getName());
    }

    @Test
    void testCubeArea() {
        Shape shape = new Cube(10);
        assertEquals(600, shape.getArea());
    }

    @Test
    void testCubeArea2() {
        Shape shape = new Cube(0.5);
        assertEquals(1.5, shape.getArea());
    }

    @Test
    void testCubeVolume() {
        Shape3D shape = new Cube(10);
        assertEquals(1000, shape.getVolume());
    }

    @Test
    void testCubeVolume2() {
        Shape3D shape = new Cube(0.5);
        assertEquals(0.13, shape.getVolume(), 0.01);
    }

    // 6 test cases for pyramid
    @Test
    void testPyramidName() {
        Shape shape = new Pyramid(10, 10, 10);
        assertEquals("pyramid", shape.getName());
    }

    @Test
    void testPyramidArea() {
        Shape shape = new Pyramid(10, 10, 10);
        System.out.println(shape.getArea());
        assertEquals(323.61, shape.getArea(), 0.01);
    }

    @Test
    void testPyramidArea2() {
        Shape shape = new Pyramid(5, 10, 15);
        assertEquals(281.13, shape.getArea(), 0.01);
    }

    @Test
    void testPyramidVolume() {
        Shape3D shape = new Pyramid(10, 10, 10);
        assertEquals(333.33, shape.getVolume(), 0.01);
    }

    @Test
    void testPyramidVolume2() {
        Shape3D shape = new Pyramid(1.5, 0.5, 2.5);
        assertEquals(0.63, shape.getVolume(), 0.01);
    }
}

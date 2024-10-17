public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 5);
        Circle circle = new Circle(20.1);
        Shape shapes[] = { rectangle, circle };

        // Prints area of each shape.
        for (Shape shape : shapes) {
            int cutoff = shape.toString().indexOf("@");                // Index at which the name of the shape ends in its toString() Object representation.
            System.out.printf(                                             // Prints "{Shape Name} Area: {Area of Shape}"
                    "%s Area: %.2f\n",
                        shape.toString().substring(0, cutoff), 
                        shape.area());
        }

        int num1 = 2, num2 = 3, num3 = 5;
        double num4 = 5.4, num5 = 6.12;

        // MathUtility Tests
        System.out.printf("%d + %d = %d\n", num1, num2, MathUtility.sum(num1, num2));                   // Two int addend test.
        System.out.printf("%d + %d + %d = %d\n", num1, num2, num3, MathUtility.sum(num1, num2, num3));  // Three int addend test.
        System.out.printf("%.2f + %.2f = %.2f\n", num4, num5, MathUtility.sum(num4, num5));             // Two float addend test.
    }
}

interface Shape {
    double area();
}

class Rectangle implements Shape {
    double length;
    double width;

    Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Circle implements Shape {
    double radius;

    Circle(double r) {
        this.radius = r;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
package polymorphism;

public class Circle extends Shape{

    private Long radius;

    @Override
    Long getPerimetr() {
        return (long) (2*Math.PI*radius);
    }

    @Override
    Long getArea() {
        return (long) (Math.PI*Math.pow(radius,2));
    }
}

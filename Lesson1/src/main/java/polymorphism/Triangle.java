package polymorphism;

public class Triangle extends Shape {
    private Long A;
    private Long B;
    private Long C;

    @Override
    Long getPerimetr() {
        return A+B+C;
    }

    @Override
    Long getArea() {
        double p = (A + B + C) >> 1;
        return (long) Math.sqrt(p*(p-A)*(p-B)*(p-C));
    }
}

package polymorphism;

public class Square extends Shape{
    private Long side;

    @Override
    Long getPerimetr() {
        return side*4;
    }

    @Override
    Long getArea() {
        return side*side;
    }
}

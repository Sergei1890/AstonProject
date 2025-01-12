package task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTask2 {

    private static final List<Shape> array = new ArrayList<>();

    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "красный", "черный");
        Shape rectangle = new Rectangle(4.0, 6.0, "синий", "зеленый");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "желтый", "фиолетовый");

        addShapesToList(
                circle,
                rectangle,
                triangle);

        showShapesInfo(array);
    }

    public static void addShapesToList(Shape... shapes) {
        Collections.addAll(array, shapes);
    }

    public static void showShapesInfo(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Характеристики фигуры: " + shape.getClass().getSimpleName());
            shape.printInfo();
            System.out.println();
        }
    }
}

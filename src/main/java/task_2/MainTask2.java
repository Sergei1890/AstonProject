package task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTask2 {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "красный", "черный");
        Shape rectangle = new Rectangle(4.0, 6.0, "синий", "зеленый");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "желтый", "фиолетовый");

        List<Shape> array = new ArrayList<>(Arrays.asList(circle,rectangle,triangle));

        for (Shape p : array) {
            System.out.println("Характеристики фигуры: " + p.getClass() + "\n");
            p.printInfo();
        }
    }
}

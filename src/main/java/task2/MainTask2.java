package task2;

import java.util.*;
import java.util.Scanner;
import java.util.Set;

public class MainTask2 {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        phoneBook.add("Деньги", "8 (800) 555-35-35");
        phoneBook.add("Павлов", "8 (800) 111-11-35");
        phoneBook.add("Павлов", "8 (800) 111-22-22");
        phoneBook.add("Петров", "8 (800) 222-22-32");
        phoneBook.add("Сидоров", "8 (800) 333-33-33");
        phoneBook.add("Васильев", "8 (800) 333-44-11");
        phoneBook.add("Васильев", "8 (800) 333-44-22");
        phoneBook.add("Васильев", "8 (800) 333-44-33");

        Set<String> uniqueSurnames = phoneBook.getUniqueSurnames();
        System.out.println("Подсказка справочник обладает следующим списком фамилий " + uniqueSurnames);

        System.out.println("Введите нужную фамилию:");
        String a = sc.next();
        List<String> phones = phoneBook.get(a);
        if (phones.isEmpty()) {
            System.out.println("Нет записей для фамилии:" + a);
        } else {
            System.out.println("Телефоны для " + a + phones);
        }
    }
}
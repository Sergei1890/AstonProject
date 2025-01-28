package task2;

import java.util.Scanner;

public class MainTask2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("8(800)555-35-35", "Деньги");
        phoneBook.add("8(800)111-11-35", "Павлов");
        phoneBook.add("8(800)111-22-22", "Павлов");
        phoneBook.add("8(800)222-22-32", "Петров");
        phoneBook.add("8(800)333-33-33", "Сидоров");
        phoneBook.add("8(800)333-44-11", "Васильев");
        phoneBook.add("8(800)333-44-22", "Васильев");
        phoneBook.add("8(800)333-44-33", "Васильев");
        phoneBook.add("8(800)333-44-33", "Васечкин");

        phoneBook.get("Васечкин");
        phoneBook.get("Деньги");
        phoneBook.get("Павлов");
        phoneBook.get("Васильев");
    }
}

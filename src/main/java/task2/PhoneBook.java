package task2;

import java.util.*;

class PhoneBook {
    private final Map<String, List<String>> phoneBook = new HashMap<>();
    private final Set<String> uniqueNumbers = new HashSet<>();

    public void add(String phoneNumber,String lastName) {
        if (uniqueNumbers.contains(phoneNumber)) {
            System.out.println("Абонент: " + lastName + ", oшибка: Номер " + phoneNumber + " уже используется.");
            return;
        }

        phoneBook.putIfAbsent(lastName, new ArrayList<>());
        phoneBook.get(lastName).add(phoneNumber);
        uniqueNumbers.add(phoneNumber);
    }

    public void get(String lastName) {
        List<String> phones = phoneBook.get(lastName);
        if (phones != null) {
            System.out.println("Телефоны для " + lastName + ": " + phones);
        } else {
            System.out.println("Телефоны для " + lastName + " не найдены.");
        }
    }
}

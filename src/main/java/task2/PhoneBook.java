package task2;

import java.util.*;

class PhoneBook {
    private Map<String, List<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        book.putIfAbsent(surname, new ArrayList<>());
        book.get(surname).add(phoneNumber);
    }

    // Метод для получения номера телефона по фамилии
    public List<String> get(String surname) {
        return book.getOrDefault(surname, Collections.emptyList());
    }
    public Set<String> getUniqueSurnames() {
        return book.keySet();
    }
}
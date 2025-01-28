package task1;

import java.util.*;


public class WordFrequency {
    public void findUniqueWords() {
        String[] words = {
                "гвоздика", "горчица", "анис", "кардамон", "кардамон",
                "миндаль", "кориандр", "гвоздика", "тмин", "миндаль",
                "мелисса", "мелисса", "анис", "мелисса", "гвоздика", "розмарин"
        };


        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова" + uniqueWords);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Слова и их кол-во в массиве: " + wordCount );
    }
}

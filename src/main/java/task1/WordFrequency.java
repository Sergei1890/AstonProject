package task1;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;


public class WordFrequency {

    public void findUniqueWords() {
        List<String> words = Arrays.asList(
                "гвоздика", "горчица", "анис", "кардамон", "кардамон",
                "миндаль", "кориандр", "гвоздика", "тмин", "миндаль",
                "мелисса", "мелисса", "анис", "мелисса", "гвоздика", "розмарин"
        );

        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Уникальные слова: " + uniqueWords);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Частота встречаемости слов: " + wordCount);
    }
}

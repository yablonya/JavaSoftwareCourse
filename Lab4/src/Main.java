import java.util.ArrayList;
import java.util.List;

/**
 * Main executable class to process text using structured components.
 */
public class Main {

    /**
     * Main method to execute the text processing.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String originalText = "Вже давно відомо, що читабельний зміст буде заважати зосередитись людині, яка оцінює композицію сторінки. Сенс використання Lorem Ipsum полягає в тому, що цей текст має більш-менш нормальне розподілення літер на відміну від, наприклад, \\\"Тут іде текст. Тут іде текст.\\\" Це робить текст схожим на оповідний. Багато програм верстування та веб-дизайну використовують Lorem Ipsum як зразок і пошук за терміном \\\"lorem ipsum\\\" відкриє багато веб-сайтів, які знаходяться ще в зародковому стані. Різні версії Lorem Ipsum з'явились за минулі роки, деякі випадково, деякі було створено зумисно (зокрема, жартівливі).";
        Text structuredText = new Text(originalText);

        // Process and print unique words in alphabetical order
        List<String> uniqueWords = extractUniqueWords(structuredText);
        printWordsInAlphabeticalOrder(uniqueWords);

        System.out.println("\nText assembled after destructuring:");
        System.out.println(structuredText);
    }

    /**
     * Extracts unique words from the text, filtering out punctuation and preserving words with apostrophes or hyphens.
     *
     * @param text the Text object to extract unique words from
     * @return a list of unique words
     */
    private static List<String> extractUniqueWords(Text text) {
        List<String> uniqueWords = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            for (Word word : sentence.getWords()) {
                String lowerCaseWord = word.getWord().toLowerCase();
                if (!uniqueWords.contains(lowerCaseWord)) {
                    uniqueWords.add(lowerCaseWord);
                }
            }
        }
        return uniqueWords;
    }

    /**
     * Prints words in alphabetical order.
     *
     * @param words the list of unique words to print
     */
    private static void printWordsInAlphabeticalOrder(List<String> words) {
        insertionSort(words);

        System.out.println("Unique words in alphabetical order:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    /**
     * Sorts a list of words alphabetically using insertion sort.
     *
     * @param words the list of words to sort
     */
    private static void insertionSort(List<String> words) {
        for (int i = 1; i < words.size(); i++) {
            String key = words.get(i);
            int j = i - 1;

            while (j >= 0 && words.get(j).compareTo(key) > 0) {
                words.set(j + 1, words.get(j));
                j = j - 1;
            }
            words.set(j + 1, key);
        }
    }
}

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
        String originalText = "Вже давно відомо, що читабельний зміст буде заважати зосередитись людині, яка оцінює композицію сторінки. Сенс використання Lorem Ipsum полягає в тому, що цей текст має більш-менш нормальне розподілення літер на відміну від, наприклад, \\\\\\\"Тут іде текст. Тут іде текст.\\\\\\\" Це робить текст схожим на оповідний. Багато програм верстування та веб-дизайну використовують Lorem Ipsum як зразок і пошук за терміном \\\\\\\"lorem ipsum\\\\\\\" відкриє багато веб-сайтів, які знаходяться ще в зародковому стані. Різні версії Lorem Ipsum з'явились за минулі роки, деякі випадково, деякі було створено зумисно (зокрема, жартівливі).";
        Text structuredText = new Text(originalText);

        // Process and print unique words in alphabetical order
        String[] uniqueWords = extractUniqueWords(structuredText);
        printWordsInAlphabeticalOrder(uniqueWords);

        System.out.println("\nText assembled after destructuring:");
        System.out.println(structuredText);
    }

    /**
     * Extracts unique words from the text, filtering out punctuation and preserving words with apostrophes or hyphens.
     *
     * @param text the Text object to extract unique words from
     * @return an array of unique words
     */
    private static String[] extractUniqueWords(Text text) {
        String[] tempWords = new String[1000]; // Initial capacity
        int uniqueCount = 0;
        for (Sentence sentence : text.getSentences()) {
            for (Word word : sentence.getWords()) {
                String lowerCaseWord = word.getWord().toLowerCase();
                boolean exists = false;
                for (int i = 0; i < uniqueCount; i++) {
                    if (tempWords[i].equals(lowerCaseWord)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    if (uniqueCount == tempWords.length) {
                        tempWords = expandArray(tempWords);
                    }
                    tempWords[uniqueCount++] = lowerCaseWord;
                }
            }
        }
        return trimArray(tempWords, uniqueCount);
    }

    /**
     * Prints words in alphabetical order.
     *
     * @param words the array of unique words to print
     */
    private static void printWordsInAlphabeticalOrder(String[] words) {
        insertionSort(words);

        System.out.println("Unique words in alphabetical order:");
        for (String word : words) {
            if (word != null) {
                System.out.println(word);
            }
        }
    }

    /**
     * Sorts an array of words alphabetically using insertion sort.
     *
     * @param words the array of words to sort
     */
    private static void insertionSort(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String key = words[i];
            int j = i - 1;

            while (j >= 0 && words[j] != null && words[j].compareTo(key) > 0) {
                words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = key;
        }
    }

    /**
     * Expands an array's capacity by doubling its size.
     *
     * @param array the original array
     * @return the expanded array
     */
    private static String[] expandArray(String[] array) {
        String[] newArray = new String[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    /**
     * Trims an array to the specified size.
     *
     * @param array the original array
     * @param size the number of elements to keep
     * @return the trimmed array
     */
    private static String[] trimArray(String[] array, int size) {
        String[] trimmedArray = new String[size];
        System.arraycopy(array, 0, trimmedArray, 0, size);
        return trimmedArray;
    }
}

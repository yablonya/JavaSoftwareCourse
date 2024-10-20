public class Main {
    public static void main(String[] args) {
        try {
            String text = "Вже давно відомо, що читабельний зміст буде заважати зосередитись людині, яка оцінює композицію сторінки. Сенс використання Lorem Ipsum полягає в тому, що цей текст має більш-менш нормальне розподілення літер на відміну від, наприклад, \"Тут іде текст. Тут іде текст.\" Це робить текст схожим на оповідний. Багато програм верстування та веб-дизайну використовують Lorem Ipsum як зразок і пошук за терміном \"lorem ipsum\" відкриє багато веб-сайтів, які знаходяться ще в зародковому стані. Різні версії Lorem Ipsum з'явились за минулі роки, деякі випадково, деякі було створено зумисно (зокрема, жартівливі).";
            String uniqueWords = getUniqueWordsInAlphabeticalOrder(text);
            System.out.println("Унікальні слова в алфавітному порядку:");
            System.out.println(uniqueWords);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    private static String getUniqueWordsInAlphabeticalOrder(String text) {
        validateText(text);

        String[] words = preprocessText(text);
        String[] uniqueWords = getUniqueWords(words);
        insertionSort(uniqueWords);

        return String.join(" ", uniqueWords);
    }

    private static void validateText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім або null.");
        }
    }

    private static String[] preprocessText(String text) {
        String textWithoutPunctuation = text.replaceAll("\\p{Punct}", "").toLowerCase();
        return textWithoutPunctuation.split("\\s+");
    }

    private static String[] getUniqueWords(String[] words) {
        int uniqueCount = 0;

        for (int i = 0; i < words.length; i++) {
            if (!isDuplicate(words[i], words, uniqueCount)) {
                words[uniqueCount++] = words[i];
            }
        }

        String[] uniqueWords = new String[uniqueCount];
        System.arraycopy(words, 0, uniqueWords, 0, uniqueCount);

        return uniqueWords;
    }

    private static boolean isDuplicate(String word, String[] words, int uniqueCount) {
        for (int j = 0; j < uniqueCount; j++) {
            if (word.equals(words[j])) {
                return true;
            }
        }
        return false;
    }

    private static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
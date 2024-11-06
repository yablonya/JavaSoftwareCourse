import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence composed of words and punctuation marks.
 */
class Sentence {
    private List<Object> elements; // Contains Word and Punctuation objects

    /**
     * Constructor to create a Sentence object from a string.
     *
     * @param sentence the string representing the sentence
     */
    public Sentence(String sentence) {
        elements = new ArrayList<>();
        parseSentence(sentence);
    }

    /**
     * Parses the sentence into words and punctuation marks.
     *
     * @param sentence the string representing the sentence
     */
    private void parseSentence(String sentence) {
        String wordBuffer = "";
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            // Check if the character is part of a word (letter, digit, apostrophe, or hyphen within a word)
            if (Character.isLetterOrDigit(ch) || ch == '\'' || (ch == '-' && i > 0 && i < sentence.length() - 1 &&
                    !Character.isWhitespace(sentence.charAt(i - 1)) && !Character.isWhitespace(sentence.charAt(i + 1)))) {

                wordBuffer += ch; // Part of a word
            } else {
                // If we encounter a space-separated dash, treat it as punctuation
                if (!wordBuffer.isEmpty()) {
                    elements.add(new Word(wordBuffer)); // Add word to elements
                    wordBuffer = ""; // Clear the buffer
                }
                if (!Character.isWhitespace(ch)) {
                    elements.add(new Punctuation(ch)); // Add punctuation mark
                }
            }
        }
        // Add the last word if it exists
        if (!wordBuffer.isEmpty()) {
            elements.add(new Word(wordBuffer));
        }
    }

    /**
     * Returns the words in the sentence, filtering out punctuation marks.
     *
     * @return a list of Word objects in this sentence
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    /**
     * Returns the string representation of the sentence.
     *
     * @return a string containing all words and punctuation in the sentence
     */
    @Override
    public String toString() {
        String sentence = "";
        for (Object element : elements) {
            if (element instanceof Word) {
                sentence += ((Word) element).toString() + " ";
            } else if (element instanceof Punctuation) {
                sentence = sentence.trim() + ((Punctuation) element).toString() + " ";
            }
        }
        return sentence.trim();
    }
}


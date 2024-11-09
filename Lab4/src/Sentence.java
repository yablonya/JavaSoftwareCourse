import java.util.Arrays;

/**
 * Represents a sentence composed of words and punctuation marks.
 */
class Sentence {
    private Object[] elements; // Contains Word and Punctuation objects
    private int elementCount; // Tracks the number of elements added

    /**
     * Constructor to create a Sentence object from a string.
     *
     * @param sentence the string representing the sentence
     */
    public Sentence(String sentence) {
        elements = new Object[sentence.length()]; // Initial capacity set to length of the sentence
        elementCount = 0;
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
                    addElement(new Word(wordBuffer)); // Add word to elements
                    wordBuffer = ""; // Clear the buffer
                }
                if (!Character.isWhitespace(ch)) {
                    addElement(new Punctuation(ch)); // Add punctuation mark
                }
            }
        }
        // Add the last word if it exists
        if (!wordBuffer.isEmpty()) {
            addElement(new Word(wordBuffer));
        }
    }

    /**
     * Adds an element to the elements array.
     *
     * @param element the object to add (either Word or Punctuation)
     */
    private void addElement(Object element) {
        if (elementCount == elements.length) {
            expandElementsArray(); // Expand the array if needed
        }
        elements[elementCount++] = element;
    }

    /**
     * Expands the elements array when it reaches capacity.
     */
    private void expandElementsArray() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    /**
     * Returns the words in the sentence, filtering out punctuation marks.
     *
     * @return an array of Word objects in this sentence
     */
    public Word[] getWords() {
        Word[] words = new Word[elementCount];
        int wordIndex = 0;
        for (int i = 0; i < elementCount; i++) {
            if (elements[i] instanceof Word) {
                words[wordIndex++] = (Word) elements[i];
            }
        }
        return Arrays.copyOf(words, wordIndex); // Return a trimmed array
    }

    /**
     * Returns the string representation of the sentence.
     *
     * @return a string containing all words and punctuation in the sentence
     */
    @Override
    public String toString() {
        String sentence = "";
        for (int i = 0; i < elementCount; i++) {
            if (elements[i] instanceof Word) {
                sentence += ((Word) elements[i]).toString() + " ";
            } else if (elements[i] instanceof Punctuation) {
                sentence = sentence.trim() + ((Punctuation) elements[i]).toString() + " ";
            }
        }
        return sentence.trim();
    }
}


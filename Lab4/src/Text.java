import java.util.Arrays;

/**
 * Represents a text composed of multiple sentences.
 */
public class Text {
    private Sentence[] sentences;
    private int sentenceCount; // Tracks the number of sentences added

    /**
     * Constructor to create a Text object from a string.
     *
     * @param text the string representing the entire text
     */
    public Text(String text) {
        sentences = new Sentence[text.length()]; // Initial capacity set to length of the text
        sentenceCount = 0;
        parseText(text);
    }

    /**
     * Parses the text into sentences.
     *
     * @param text the string representing the entire text
     */
    private void parseText(String text) {
        String[] sentenceArray = text.split("(?<=\\.)\\s+"); // Split by period followed by space
        for (String s : sentenceArray) {
            addSentence(new Sentence(s));
        }
    }

    /**
     * Adds a sentence to the sentences array.
     *
     * @param sentence the Sentence object to add
     */
    private void addSentence(Sentence sentence) {
        if (sentenceCount == sentences.length) {
            expandSentencesArray(); // Expand the array if needed
        }
        sentences[sentenceCount++] = sentence;
    }

    /**
     * Expands the sentences array when it reaches capacity.
     */
    private void expandSentencesArray() {
        Sentence[] newSentences = new Sentence[sentences.length * 2];
        System.arraycopy(sentences, 0, newSentences, 0, sentences.length);
        sentences = newSentences;
    }

    /**
     * Returns the list of sentences in this text.
     *
     * @return an array of Sentence objects in this text
     */
    public Sentence[] getSentences() {
        return Arrays.copyOf(sentences, sentenceCount); // Return a trimmed array
    }

    /**
     * Returns the string representation of the text.
     *
     * @return a string containing all sentences in the text
     */
    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < sentenceCount; i++) {
            text += sentences[i].toString() + " ";
        }
        return text.trim();
    }
}


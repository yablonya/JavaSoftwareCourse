import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text composed of multiple sentences.
 */
public class Text {
    private List<Sentence> sentences;

    /**
     * Constructor to create a Text object from a string.
     *
     * @param text the string representing the entire text
     */
    public Text(String text) {
        sentences = new ArrayList<>();
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
            sentences.add(new Sentence(s));
        }
    }

    /**
     * Returns the list of sentences in this text.
     *
     * @return a list of Sentence objects in this text
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Returns the string representation of the text.
     *
     * @return a string containing all sentences in the text
     */
    @Override
    public String toString() {
        String text = "";
        for (Sentence sentence : sentences) {
            text += sentence.toString() + " ";
        }
        return text.trim();
    }
}

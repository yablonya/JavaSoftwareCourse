/**
 * Represents a word composed of multiple letters and possibly apostrophes or hyphens.
 */
public class Word {
    private Letter[] letters;

    /**
     * Constructor to create a Word object from a string.
     *
     * @param word the string representing the word, including possible apostrophes or hyphens
     */
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Returns the word as a string.
     *
     * @return the string representation of this word
     */
    public String getWord() {
        StringBuilder wordBuilder = new StringBuilder();
        for (Letter letter : letters) {
            wordBuilder.append(letter.getCharacter());
        }
        return wordBuilder.toString();
    }

    /**
     * Returns the string representation of the word.
     *
     * @return a string containing all characters in the word
     */
    @Override
    public String toString() {
        return getWord();
    }
}

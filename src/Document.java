import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Document {
    private String text;
    private ArrayList<String> sentences;
    private boolean isSentencesCurrent = true;
    private String[] words;
    private boolean isWordsCurrent = true;

    public static Document getDocumentFrom(String filepath) {
        String text = readFileAsString(filepath);
        Document d = new Document(text);
        return d;
    }

    public Document(String text) {
        this.text = text;
        sentences = splitIntoSentences();
        words = splitIntoWords();
    }

    private static String readFileAsString(String filename) {
        Scanner scanner;
        StringBuilder output = new StringBuilder();

        try {
            scanner = new Scanner(new FileInputStream(filename), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.append(line.trim() + "\n");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }

        return output.toString();
    }

    private String[] splitIntoWords() {
        String[] words = removePunctuation().split("\\s+");
        return words;
    }

    public void setText(String newText) {
        this.text = newText;
        isSentencesCurrent = false;
        isWordsCurrent = false;
    }

    public int getWordCount() {
        return getWords().length;
    }

    private String removePunctuation() {
        String newPassage = "";
        for (int i = 0; i < text.length(); i++) {
            String letter = text.substring(i, i + 1);
            if ("qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM ".contains(letter)) {
                newPassage += letter;
            }
        }
        return newPassage;
    }

    private ArrayList<String> splitIntoSentences() {
        ArrayList<String> output = new ArrayList<>();

        Locale locale = Locale.US;
        BreakIterator breakIterator = BreakIterator.getSentenceInstance(locale);
        breakIterator.setText(text);

        int prevIndex = 0;
        int boundaryIndex = breakIterator.first();
        while (boundaryIndex != BreakIterator.DONE) {
            String sentence = text.substring(prevIndex, boundaryIndex).trim();
            if (sentence.length() > 0)
                output.add(sentence);
            prevIndex = boundaryIndex;
            boundaryIndex = breakIterator.next();
        }

        String sentence = text.substring(prevIndex).trim();
        if (sentence.length() > 0)
            output.add(sentence);

        return output;
    }

    private ArrayList<String> getSentences() {
        if (isSentencesCurrent) {
            return sentences;
        } else {
            isSentencesCurrent = true;
            sentences = splitIntoSentences();
            return sentences;
        }
    }

    private String[] getWords() {
        if (isWordsCurrent) {
            return words;
        } else {
            isWordsCurrent = true;
            words = splitIntoWords();
            return words;
        }
    }

    public int getSentenceCount() {
        return getSentences().size();
    }

    public double avgWordsPerSentence() {
        return (double) getWordCount() / getSentenceCount();
    }

    public double avgCharactersPerWord() {
        return (double) text.length() / getWordCount();
    }

    public ArrayList<String> getUniqueWords() {
        String[] words = splitIntoWords();
        ArrayList<String> newWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (!newWords.contains(word)) {
                newWords.add(word);
            }
        }
        return newWords;
    }

    public int getVocabularySize() {
        return getUniqueWords().size();
    }

    public double getFKReadabilityScore() {
        return 206.135 - 1.01 * (getWordCount() / getSentenceCount()) - 84.6 * (getSyllableCount() / getWordCount());
    }

    private int getSyllableCount() {
        return totalSyllables(splitIntoWords());
    }

    private static int totalSyllables(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int syllables = syllablesFor(word);
            count += syllables;
        }
        return count;
    }

    private static int syllablesFor(String testWord) {
        boolean inVowelChain = false;
        int boundaries = 0;

        for (int i = 0; i < testWord.length(); i++) {
            String letter = testWord.substring(i, i + 1);
            if (isVowel(letter)) {
                if (!inVowelChain) {
                    inVowelChain = true;
                    boundaries++;
                }
            } else {
                inVowelChain = false;
            }
        }

        return boundaries;
    }

    private static boolean isVowel(String letter) {
        return "aeiouy".contains(letter);
    }

    public int countOccurrences(String target) {
        int num = 0;

        for (String word : words) {
            if (word.toLowerCase().contains(target)) {
                num++;
            }
        }
        return num;
    }

    public ArrayList<Integer> getLocationOfOccurence(String target) {
        String[] getWords = splitIntoWords();
        ArrayList<Integer> locations = new ArrayList<>();

        for (int i = 0; i < getWords.length; i++) {
            if (target.equals(getWords[i])) {
                locations.add(i);
            }
        }
        return locations;
    }

    public boolean isInSameSentence(String target1, String target2) {

        for (String sentence : splitIntoSentences()) {
            if (sentence.contains(target1) && sentence.contains(target2)) {
                return true;
            }
        }
        return false;
    }

}


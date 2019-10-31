import java.util.ArrayList;
import java.util.Arrays;

public class PredatoryWords {
    private Document predatoryCorpus;
    private String exampleText;
    private Document verbs;
    private Document pronoun;
    private final int PERCENT_THRESHOLD = 15;
    String[] predatoryWords;
    String[] verbTense;
    String[] pronouns;
    String[] exampleTextwordList;
    private boolean isPredatory;

    /*
remove punctuation ??????????????????

     */

    public PredatoryWords(Document predatoryWords, String text, Document pronouns, Document verbs) {
        this.predatoryCorpus = predatoryWords;
        this.exampleText = text;
        this.verbs = verbs;
        this.pronoun = pronouns;
        this.predatoryWords = predatoryWords.splitIntoLines();
        this.exampleTextwordList = removePunctuation(exampleText).split("\\s+");
        this.verbTense = verbs.splitIntoLines();
        this.pronouns = pronouns.splitIntoLines();
    }

    //getters and setters
    public Document getPredatoryCorpus() {
        return predatoryCorpus;
    }

    public String removePunctuation(String exampleText) {
        String newPassage = "";
        for (int i = 0; i < exampleText.length(); i++) {
            String letter = exampleText.substring(i, i + 1);
            if ("qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM ".contains(letter)) {
                newPassage += letter;
            }
        }
        return newPassage;
    }

    public boolean containsPredatory() {
        int count = 0;
        for (String word : predatoryWords) {
            for (String textWord : exampleTextwordList) {
                if (textWord.equalsIgnoreCase(word)) {
                    count++;
                }
            }
        }
        return count >= 1;
    }

    //
    public boolean containsPredatoryVerbTense() {
        for (String verb : verbTense) {
            for (String text : exampleTextwordList) {
                if (text.equalsIgnoreCase(verb.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPronoun() {
        for (String pronoun : pronouns) {
            for (String text : exampleTextwordList) {
                if (text.equalsIgnoreCase(pronoun.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isPredatory() {
        return isPronoun() && containsPredatoryVerbTense() && containsPredatory();
    }
}
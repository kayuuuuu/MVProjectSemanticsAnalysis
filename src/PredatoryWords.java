import java.util.ArrayList;

public class PredatoryWords {
    private Document predatoryCorpus;
    private Document exampleText;
    private final int PERCENT_THRESHOLD = 15;
    String[] predatoryWords;
    String[] verbTense;
    String[] pronouns;
    String[] exampleTextwordList;
    private boolean isPredatory;

    //.equalsIgnoreCase !!!!

    /*
  test data sets and see if the proximity method ( distance between 2 words) would be helpful


     */

    public PredatoryWords(Document corpus, Document text) {
        this.predatoryCorpus = corpus;
        this.exampleText = text;
        this.predatoryWords = corpus.splitIntoWords();
        this.exampleTextwordList = exampleText.splitIntoWords();
    }

    //getters and setters
    public Document getPredatoryCorpus() {
        return predatoryCorpus;
    }


    // actual methods
//    public double getPercent() {
//        int count = 0;
//        for (String word : predatoryWords) {
//            for (String textWord : exampleTextwordList) {
//                if (textWord.equalsIgnoreCase(word)) {
//                    count++;
//                }
//            }
//        }
//        return (double) count / exampleTextwordList.length;
//    }


//    public void setPredatory(double percentage) {
//        if (percentage > PERCENT_THRESHOLD) {
//            isPredatory = true;
//        }
//    }

    public boolean containsPredatory() {
        int count = 0;
        for (String word : predatoryWords) {
            for (String textWord : exampleTextwordList) {
                if (textWord.equalsIgnoreCase(word)) {
                    count++;
                }
            }
        }
        return count > 1;
    }

    //
    public boolean containsPredatoryVerbTense() {
        for (String verb : verbTense) {
            for (String text : exampleTextwordList) {
                if (text.equalsIgnoreCase(verb)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPronoun() {
        for (String pronoun : pronouns) {
            for (String text : exampleTextwordList) {
                if (text.equalsIgnoreCase(pronoun)) {
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
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
/*
**notes for improvement**
- make it cleaner
* just fix ur api overall


*/

public class Document {
    String text;
    ArrayList<String> sentences = TextLib.splitIntoSentences(text);

    public static Document getDocText(String filename) {
        String text = TextLib.readFileAsString(filename);
        Document d = new Document(text);
        return d;
    }


    public Document(String text) {
        this.text = text;

    }

    public int getWordCount() {
        return getWords().size();
    }

    public int getSentencCount() {
        return sentences.size();

    }

    public ArrayList<String> getWords() {
        ArrayList<String> wordList = new ArrayList<String>();

        for (int i = 0; i < sentences.size(); i++) {
            String[] words = sentences.get(i).split(" ");
            wordList.add(words[i]);

        }
        return wordList;
    }

    //make a word class and find occurences for word ??? so
   /*
   if(word object is in the list)
       add count to the object

    */
    public ArrayList<String> getEachWordOnce() {
        ArrayList<String> eachWordOnce = new ArrayList<String>();
        for (String word : getWords()) {
            if (!eachWordOnce.contains(word)) {
                eachWordOnce.add(word);
            }
        }
        return eachWordOnce;

    }

    public double getFKReadabilityScore() {
//        return 206.835 - (1.015 * ((double) getWordCount() / getSentencCount())) - (84.6 * ((double) TextLib.getSyllablesFromLine() / getWordCount()));
        return 0;


    }

    public double getAvgWordsPerSentence() {

        return (double) getWords().size() / sentences.size();

    }

    public double getAvgChars() {
        int chars = 0;
        for (String word : getWords()) {
            chars += word.length();
        }
        return (double) chars / getWords().size();
    }

    public int countOccurrences(String target) {
        int count = 0;
        for (String word : getWords()) {
            if (word.equalsIgnoreCase(target)) {
                count++;
            }
        }
        return count;
    }

    public int[] indexOfOccurrences(String target) {
        int[] indexes = new int[countOccurrences(target)];
        for (int i = 0; i < getWords().size(); i++) {
            if (getWords().get(i).equalsIgnoreCase(target)) {
                indexes[i] = getWords().indexOf(getWords().get(i));
            }

        }
        return indexes;
    }

    public boolean CoOccur(String target1, String target2) {
        if (getWords().contains(target1) && getWords().contains(target2)) {
            return true;
        }
        return false;
    }

    public Document replace(String word) {
        Document document = new Document("text");
        return document;

    }


}


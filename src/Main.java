import javax.print.Doc;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Document text = Document.getDocumentFrom("data/Test suite .txt");
        Document predatoryWords = Document.getDocumentFrom("data/threatening_guilting_scare tactic words.txt");
        Document pronouns = Document.getDocumentFrom("data/Pronouns and nouns.txt");
        Document verbs = Document.getDocumentFrom("data/Verb tense.txt");
        String[] testSentences = text.splitIntoLines();
        Document compareText = Document.getDocumentFrom("data/Test suite with boolean values .txt");
        String[] compareSentences = compareText.splitIntoLines();
        String[] booleans = new String[compareSentences.length];
        for(int i = 0; i < compareSentences.length; i++){
            booleans[i] = compareSentences[i].substring(compareSentences[i].indexOf(",") + 2);
        }

        int count = 0;

        for (int i = 0; i<testSentences.length; i++) {
             PredatoryWords p = new PredatoryWords(predatoryWords, testSentences[i], pronouns, verbs);
                if((p.isPredatory()) == Boolean.parseBoolean(booleans[i])){
                    count++;
                }




        }
        System.out.println((double) count / testSentences.length*100);
        System.out.println(count);
        System.out.println(testSentences.length);


        //each predatory word is now stored in a String array


    }

    

}

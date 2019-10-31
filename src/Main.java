import javax.print.Doc;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Document text = Document.getDocumentFrom("data/Test suite .txt");
        Document predatoryWords = Document.getDocumentFrom("data/threatening_guilting_scare tactic words.txt");
        Document pronouns = Document.getDocumentFrom("data/Pronouns and nouns.txt");
        Document verbs = Document.getDocumentFrom("data/Verb tense.txt");
        String[] testSentences = text.splitIntoLines();
        for (String sentence : testSentences) {
            PredatoryWords p = new PredatoryWords(predatoryWords, sentence, pronouns, verbs);
//            System.out.println(sentence + ",\t" + p.isPredatory());
//            System.out.println(sentence + " " + p.isPronoun());
//            System.out.println(sentence + " " + p.containsPredatoryVerbTense());
            System.out.println(sentence + " " + p.containsPredatory());


        }


        //each predatory word is now stored in a String array


    }

}

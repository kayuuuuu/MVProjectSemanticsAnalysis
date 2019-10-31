import java.util.Arrays;

public class testMain {
    public static void main(String[] args) {
        String text = ("imm’a kill u ");
        Document predatoryWords = Document.getDocumentFrom("data/threatening_guilting_scare tactic words.txt");
        Document pronouns = Document.getDocumentFrom("data/Pronouns and nouns.txt");
        Document verbs = Document.getDocumentFrom("data/Verb tense.txt");

        PredatoryWords p = new PredatoryWords(predatoryWords, text, pronouns, verbs);

//        System.out.println(p.containsPredatory());
//        System.out.println(Arrays.toString(p.predatoryWords));
//        System.out.println(Arrays.toString(p.exampleTextwordList));
        System.out.println(p.containsPredatory());
    }
}

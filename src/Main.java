import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Document text = new Document("anal");
//        Document list = Document.getDocumentFrom("data/badWordsList.txt");
//        ArrayList<String> words = list.getUniqueWords();
//        for(String word : words){
//            System.out.println(word);
//        }
//        PredatoryWords p = new PredatoryWords(list);
//        System.out.println(p.getPercent(text));

        Document dataSet = new Document("data/badWordsList.txt");
        String[] wordList = dataSet.splitIntoWords();


    }

}

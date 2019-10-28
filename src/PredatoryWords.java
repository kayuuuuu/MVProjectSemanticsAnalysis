public class PredatoryWords {
    private Document corpus;
    private boolean containsPredatory;
    private boolean containsColloquial;
    private boolean isPredatory;
    private Document exampleText;
    private final int PERCENT_THRESHOLD = 15;

    /*
    stretch : use verb tenses to checko el predatorio palabras
    espanolo
    make a count variable that adds a isPredatoryCount every time we run a method (based on phrase)

     */

    public PredatoryWords(Document corpus, Document text) {
        this.corpus = corpus;
        this.isPredatory = isPredatory;
        this.exampleText = text;
    }

    public double getPercent(){
        String[] wordList = corpus.splitIntoWords();
        String[] wordText = exampleText.splitIntoWords();
        int count = 0;
        for(String word : wordList){
            for(String textWord : wordText){
                if(textWord.equalsIgnoreCase(word)){
                    count++;
                }
            }
        }
        return (double)count/wordText.length;
    }


    public void setPredatory(double percentage) {
        if(percentage > PERCENT_THRESHOLD){
            isPredatory = true;
        }
    }

    public Document getCorpus() {
        return corpus;
    }

    public void setCorpus(Document corpus) {
        this.corpus = corpus;
    }

    public boolean isPredatory() {
        String[] wordList = corpus.splitIntoWords();
        String[] wordText = exampleText.splitIntoWords();
        int count = 0;
        for(String word : wordList){
            for(String textWord : wordText){
                if(textWord.equalsIgnoreCase(word)){
                    count++;
                }
            }
        }
        return count > 1;
    }
}

public class PredatoryWords {
    private Document list;
    private boolean containsPredatory;
    private boolean containsColloquial;
    private boolean isPredatory;
    private final int PERCENT_THRESHOLD = 15;
    /*
    stretch : use verb tenses to checko el predatorio palabras
    espanolo
    make a count variable that adds a isPredatoryCount every time we run a method (based on phrase)

     */

    public PredatoryWords(Document text) {
        this.list = text;
        this.isPredatory = isPredatory;
    }

    public double getPercent(Document text){
        String[] wordList = list.splitIntoWords();
        String[] wordText = text.splitIntoWords();
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

    public Document getList() {
        return list;
    }

    public void setList(Document list) {
        this.list = list;
    }

    public boolean isPredatory() {
        return isPredatory;
    }
}

public class Words {
    private String word;
    private int count;


    public Words(String word) {
        this.word = word;
    }
    public void addCount(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }
}

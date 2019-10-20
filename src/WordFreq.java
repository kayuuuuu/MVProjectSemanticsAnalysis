public class WordFreq {
    private String word;
    private long count;

    public WordFreq(String word, long count) {
        this.word = word;
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void addCount(long num) {
        count += num;
    }
}


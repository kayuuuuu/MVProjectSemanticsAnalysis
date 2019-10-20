import java.util.ArrayList;

public class WordBucketPriorityQueue {
    ArrayList<Words> words;
    ArrayList<Words> noRepeats = new ArrayList<Words>();

    public WordBucketPriorityQueue() {
        words = new ArrayList<Words>();
    }

    public void add(Words word) {
        if (words.contains(word)) {
            word.addCount();
            sort(words);
        }
        words.add(word);
        word.addCount();
        sort(words);
    }

    private void sort(ArrayList<Words> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                compare(i, j);

            }

        }
    }

    public void compare(int i, int j) {
        Words countOfWord = words.get(i);
        Words compare = words.get(j);
        if (compare.getCount() < countOfWord.getCount()) {
            words.set(i, compare);
            words.set(j, countOfWord);
        }

    }

    public void addNTimes(Words word, long times) {
        for (long i = 0; i < times; i++) {
            words.add(word);
        }
    }

    public int getCountOf(Words target) {
        return target.getCount();
    }

    public int getSize() {
        int totalSize = 0;
        for (Words word : words) {
            totalSize += word.getCount();
        }
        return totalSize;
    }

    public int getNumUnique() {
        return words.size();
    }

    public String getMostFreq() {
        return words.get(0).getWord();

    }
}

//    public String[] getNFreq(int n) {
//
//
//}
//

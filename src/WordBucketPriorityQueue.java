import java.util.ArrayList;

public class WordBucketPriorityQueue {
    private static ArrayList<WordFreq> entries;

    public WordBucketPriorityQueue() {
        entries = new ArrayList<>();
    }

    public void add(String item) {
        add(item, 1);
    }

    private void sortBucket(int index) {
        while (index > 0 && entries.get(index).getCount() > entries.get(index - 1).getCount()) {
            switchIndexes(entries, index, index - 1);
        }
    }

    private void switchIndexes(ArrayList<WordFreq> entries, int i1, int i2) {
        WordFreq firstEntry = entries.get(i1);
        WordFreq secondEntry = entries.get(i2);

        entries.set(i1, secondEntry);
        entries.set(i2, firstEntry);
    }

    private int getIndex(String item) {
        for (int i = 0; i < entries.size(); i++) {
            WordFreq entry = entries.get(i);
            if (entry.getWord().equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void add(String item, long count) {
        int index = getIndex(item);
        if (index == -1) {
            WordFreq word = new WordFreq(item, 1);
            entries.add(word);
            index = entries.size() - 1;
        } else {
            WordFreq word = entries.get(index);
            word.addCount(count);
        }

        sortBucket(index);
    }

    public long getCountOf(String target) {
        for (WordFreq entry : entries) {
            if (entry.getWord().equals(target)) {
                return entry.getCount();
            }
        }
        WordFreq entry = getEntryFor(target);
        if (entry != null) {
            return entry.getCount();
        } else {
            return 0;
        }
    }

    private WordFreq getEntryFor(String target) {
        for (WordFreq entry : entries) {
            if (entry.getWord().equals(target)) {
                return entry;
            }
        }
        return null;
    }

    public long size() {
        long sum = 0;
        for (WordFreq entry : entries) {
            sum += entry.getCount();
        }
        return sum;
    }

    public int getNumUnique() {
        return entries.size();
    }

    public String getMostFreq() {
        if (size() == 0) return "";
        else return entries.get(0).getWord();
    }
}


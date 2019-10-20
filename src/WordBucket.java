import java.util.ArrayList;

public class WordBucket {
    ArrayList<String> words;
    ArrayList<String> noRepeats = new ArrayList<String>();

    public WordBucket() {
        words = new ArrayList<String>();
    }

    public void add(String word) {
        words.add(word);

    }

    public void addNTimes(String word, long times) {
        for (long i = 0; i < times; i++) {
            words.add(word);
        }
    }

    public int getCountOf(String target) {
        int count = 0;
        for (String word : words) {
            if (target.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }

    public int getSize() {
        return words.size();
    }

    public int getNumUnique() {
        ArrayList<String> noRepeats = new ArrayList<String>();
        for (String word : words) {
            if (!noRepeats.contains(word)) {
                noRepeats.add(word);

            }

        }
        return noRepeats.size();
    }

    public String getMostFreq() {
        int biggest = getCountOf(words.get(0));
        String mostFrequent = "";
        for (String word : words) {
            int count = getCountOf(word);
            if (count > biggest) {
                biggest = count;
                mostFrequent = word;
            }

        }


        return mostFrequent;

    }
    public String[] getNFreq(int n){
        String[] topFreq = new String[n];
        ArrayList<String> noFreq =  new ArrayList<String>();
        topFreq[0] = getMostFreq();

        for (int i = 0; i < words.size(); i++) {

            if(!getMostFreq().equalsIgnoreCase(words.get(i))){
                noFreq.add(words.get(i));
            }

        }
    return topFreq;
    }

}


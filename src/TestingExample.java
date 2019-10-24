public class TestingExample {
    //if they give us a hand made data set, we can store them into an arraylist containing the phrase and a boolean statement letting us know if it's predatory or not

    private String phrase;
    private boolean isPredatory;

    public TestingExample(String phrase, boolean isPredatory) {
        this.phrase = phrase;
        this.isPredatory = isPredatory;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public boolean isPredatory() {
        return isPredatory;
    }

    public void setPredatory(boolean predatory) {
        isPredatory = predatory;
    }
}

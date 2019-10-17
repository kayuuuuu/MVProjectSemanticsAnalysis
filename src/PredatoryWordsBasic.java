public class PredatoryWordsBasic {
    private String text;
    private boolean isPredatory;

    public PredatoryWordsBasic(String text, boolean isPredatory) {
        this.text = text;
        this.isPredatory = isPredatory;
    }

    public void setPredatory(boolean predatory) {
        isPredatory = predatory;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPredatory() {
        return isPredatory;
    }
}

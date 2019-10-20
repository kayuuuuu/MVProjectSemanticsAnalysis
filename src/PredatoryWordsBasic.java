import javax.print.Doc;

public class PredatoryWordsBasic {
    private Document text;
    private boolean isPredatory;

    public PredatoryWordsBasic(Document text, boolean isPredatory) {
        this.text = text;
        this.isPredatory = isPredatory;
    }


    public void setPredatory(boolean predatory) {
        isPredatory = predatory;
    }

    public Document getText() {
        return text;
    }

    public void setText(Document text) {
        this.text = text;
    }

    public boolean isPredatory() {
        return isPredatory;
    }
}

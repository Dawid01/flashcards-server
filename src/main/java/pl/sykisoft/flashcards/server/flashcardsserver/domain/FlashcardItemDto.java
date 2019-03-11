package pl.sykisoft.flashcards.server.flashcardsserver.domain;

public class FlashcardItemDto {

    private Long id;

    private String firstWord;

    private String secondWord;

    private String firstDescription;

    private String secondDescription;

    private boolean know;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public String getFirstDescription() {
        return firstDescription;
    }

    public void setFirstDescription(String firstDescription) {
        this.firstDescription = firstDescription;
    }

    public String getSecondDescription() {
        return secondDescription;
    }

    public void setSecondDescription(String secondDescription) {
        this.secondDescription = secondDescription;
    }

    public boolean isKnow() {
        return know;
    }

    public void setKnow(boolean know) {
        this.know = know;
    }
}

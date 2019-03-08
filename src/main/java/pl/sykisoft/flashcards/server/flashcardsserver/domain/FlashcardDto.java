package pl.sykisoft.flashcards.server.flashcardsserver.domain;

public class FlashcardDto {

    private Long id;
    private String title;
    private String description;
    private int flashcards;
    private int knowsFlashcards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(int flashcards) {
        this.flashcards = flashcards;
    }

    public int getKnowsFlashcards() {
        return knowsFlashcards;
    }

    public void setKnowsFlashcards(int knowsFlashcards) {
        this.knowsFlashcards = knowsFlashcards;
    }
}

package pl.sykisoft.flashcards.server.flashcardsserver.model;

import org.springframework.hateoas.core.Relation;

import javax.persistence.*;

@Entity
@Table(name = "FlashcardItems")
public class FlashcardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstWord;

    private String secondWord;

    private String firstDescription;

    private String secondDescription;

    private boolean know;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Flashcard flashcard;

//    public FlashcardItem() {
//    }
//
//    public FlashcardItem(String firstWord, String secondWord, String firstDescription, String secondDescription, boolean know, Flashcard flashcard) {
//        this.firstWord = firstWord;
//        this.secondWord = secondWord;
//        this.firstDescription = firstDescription;
//        this.secondDescription = secondDescription;
//        this.know = know;
//        this.flashcard = flashcard;
//    }

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

    public Flashcard getFlashcard() {
        return flashcard;
    }

    public void setFlashcard(Flashcard flashcard) {
        this.flashcard = flashcard;
    }
}

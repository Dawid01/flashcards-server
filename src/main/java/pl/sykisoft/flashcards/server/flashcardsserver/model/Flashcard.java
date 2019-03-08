package pl.sykisoft.flashcards.server.flashcardsserver.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

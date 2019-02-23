package pl.sykisoft.flashcards.server.flashcardsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sykisoft.flashcards.server.flashcardsserver.model.FlashCard;

public interface FlashCardRepository extends JpaRepository<FlashCard,Long> {
}

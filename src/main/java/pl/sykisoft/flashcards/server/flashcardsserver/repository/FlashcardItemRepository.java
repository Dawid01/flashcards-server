package pl.sykisoft.flashcards.server.flashcardsserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sykisoft.flashcards.server.flashcardsserver.model.FlashcardItem;

public interface FlashcardItemRepository extends JpaRepository<FlashcardItem,Long> {

    @Query(value = "SELECT f FROM FlashcardItem f WHERE f.flashcard.id =:flashcardId",
            countQuery = "SELECT count(f) FROM FlashcardItem f WHERE f.flashcard.id =:flashcardId",
            nativeQuery = false)
    Page<FlashcardItem> findFlashcardItem(@Param("flashcardId") long flashcardId, Pageable pageable);
}

package pl.sykisoft.flashcards.server.flashcardsserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sykisoft.flashcards.server.flashcardsserver.model.Flashcard;

public interface FlashCardRepository extends JpaRepository<Flashcard,Long> {

    @Query(value = "SELECT f FROM Flashcard f WHERE f.user.id =:userId",
            countQuery = "SELECT count(f) FROM Flashcard f WHERE f.user.id =:userId",
            nativeQuery = false)
    Page<Flashcard> findUsersFlashCards(@Param("userId") long userId, Pageable pageable);
}

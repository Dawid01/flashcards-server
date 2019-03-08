package pl.sykisoft.flashcards.server.flashcardsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sykisoft.flashcards.server.flashcardsserver.domain.FlashcardDto;
import pl.sykisoft.flashcards.server.flashcardsserver.model.Flashcard;
import pl.sykisoft.flashcards.server.flashcardsserver.model.User;
import pl.sykisoft.flashcards.server.flashcardsserver.repository.FlashCardRepository;

import javax.validation.Valid;

@RestController
public class FlashCardController extends AbstractController {

    @Autowired
    private FlashCardRepository flashCardRepository;

    @GetMapping("/flashcards")
    public Page<FlashcardDto> getFlashcards(Pageable pageable) {
        User user = getCurrentUser();
        return flashCardRepository.findUsersFlashCards(user.getId(),pageable).map(this::convert);
    }


    @PostMapping("/flashcards")
    public FlashcardDto createQuestion(@Valid @RequestBody Flashcard flashCard) {
        flashCard.setUser(getCurrentUser());
        return convert(flashCardRepository.save(flashCard));
    }

    @PutMapping("/flashcards/{id}")
    public FlashcardDto updateFlashcard(@PathVariable Long flashcardId,
                                     @Valid @RequestBody Flashcard flashcard) {
        return flashCardRepository.findById(flashcardId)
                .map(question -> {
                    question.setTitle(flashcard.getTitle());
                    question.setDescription(flashcard.getDescription());
                    question.setFlashcards(flashcard.getFlashcards());
                    question.setKnowsFlashcards(flashcard.getKnowsFlashcards());
                    return convert(flashCardRepository.save(question));
                }).orElseThrow(() -> new ResourceNotFoundException("Flashcard not found with id " + flashcardId));
    }



    @DeleteMapping("/flashcards/{flashcardId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long flashcardId) {
        return flashCardRepository.findById(flashcardId)
                .map(question -> {
                    flashCardRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Flashcard not found with id " + flashcardId));
    }

    private FlashcardDto convert(Flashcard flashcard) {
        FlashcardDto dto = new FlashcardDto();
        dto.setId(flashcard.getId());
        dto.setTitle(flashcard.getTitle());
        dto.setDescription(flashcard.getDescription());
        dto.setFlashcards(flashcard.getFlashcards());
        dto.setKnowsFlashcards(flashcard.getKnowsFlashcards());
        return dto;
    }
}

package pl.sykisoft.flashcards.server.flashcardsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sykisoft.flashcards.server.flashcardsserver.model.FlashCard;
import pl.sykisoft.flashcards.server.flashcardsserver.repository.FlashCardRepository;

import javax.validation.Valid;

@RestController
public class FlashCardController {

    @Autowired
    private FlashCardRepository flashCardRepository;

    @GetMapping("/flashcards")
    public Page<FlashCard> getFlashcards(Pageable pageable) {
        return flashCardRepository.findAll(pageable);
    }


    @PostMapping("/flashcards")
    public FlashCard createQuestion(@Valid @RequestBody FlashCard flashCard) {
        return flashCardRepository.save(flashCard);
    }

    @PutMapping("/flashcards/{flashcardId}")
    public FlashCard updateFlashcard(@PathVariable Long flashcardId,
                                     @Valid @RequestBody FlashCard flashcard) {
        return flashCardRepository.findById(flashcardId)
                .map(question -> {
                    question.setTitle(flashcard.getTitle());
                    question.setDescription(flashcard.getDescription());
                    return flashCardRepository.save(question);
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
}

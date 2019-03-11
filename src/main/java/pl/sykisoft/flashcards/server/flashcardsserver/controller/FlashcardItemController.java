package pl.sykisoft.flashcards.server.flashcardsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sykisoft.flashcards.server.flashcardsserver.domain.FlashcardItemDto;
import pl.sykisoft.flashcards.server.flashcardsserver.model.Flashcard;
import pl.sykisoft.flashcards.server.flashcardsserver.model.FlashcardItem;
import pl.sykisoft.flashcards.server.flashcardsserver.repository.FlashcardItemRepository;

import javax.validation.Valid;

@RestController
public class FlashcardItemController extends AbstractController{


    @Autowired
    private FlashcardItemRepository flashcardItemRepository;

    @GetMapping("/flashcardItems/{id}")
    public Page<FlashcardItemDto> getFlashcardsItem(@PathVariable(name = "id") Long flashcardItemId, Pageable pageable) {
        return flashcardItemRepository.findFlashcardItem(flashcardItemId, pageable).map(this::convert);
    }



    @PostMapping("/flashcardItems")
    public FlashcardItemDto createQuestion(@Valid @RequestBody FlashcardItem flashcardItem,@Valid @RequestBody Flashcard flashcard) {
        flashcardItem.setFlashcard(flashcard);
        return convert(flashcardItemRepository.save(flashcardItem));
    }

    @PutMapping("/flashcardItems/{id}")
    public FlashcardItemDto updateFlashcardItem(@PathVariable Long flashcardItemId,
                                        @Valid @RequestBody FlashcardItem flashcard) {
        return flashcardItemRepository.findById(flashcardItemId)
                .map(question -> {
                    question.setFirstWord(flashcard.getFirstWord());
                    question.setSecondWord(flashcard.getSecondWord());
                    question.setFirstDescription(flashcard.getFirstDescription());
                    question.setSecondDescription(flashcard.getSecondDescription());
                    question.setKnow(flashcard.isKnow());
                    return convert(flashcardItemRepository.save(question));
                }).orElseThrow(() -> new ResourceNotFoundException("FlashcardItem not found with id " + flashcardItemId));
    }



    @DeleteMapping("/flashcardItems/{flashcardItemId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long flashcardItemId) {
        return flashcardItemRepository.findById(flashcardItemId)
                .map(question -> {
                    flashcardItemRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("FlashcardItem not found with id " + flashcardItemId));
    }

    private FlashcardItemDto convert(FlashcardItem flashcard) {
        FlashcardItemDto dto = new FlashcardItemDto();
        dto.setId(flashcard.getId());
        dto.setId(flashcard.getId());
        dto.setFirstWord(flashcard.getFirstWord());
        dto.setSecondWord(flashcard.getSecondWord());
        dto.setFirstDescription(flashcard.getFirstDescription());
        dto.setSecondDescription(flashcard.getSecondDescription());
        dto.setKnow(flashcard.isKnow());
        return dto;
    }
}

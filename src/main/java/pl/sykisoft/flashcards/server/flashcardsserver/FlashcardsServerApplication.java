package pl.sykisoft.flashcards.server.flashcardsserver;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sykisoft.flashcards.server.flashcardsserver.model.Flashcard;
import pl.sykisoft.flashcards.server.flashcardsserver.model.User;
import pl.sykisoft.flashcards.server.flashcardsserver.repository.FlashCardRepository;
import pl.sykisoft.flashcards.server.flashcardsserver.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FlashcardsServerApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlashCardRepository flashCardRepository;

    public static void main(String[] args) {
        SpringApplication.run(FlashcardsServerApplication.class, args);
    }


    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            initUser();
            initFlashCards();
        };
    }

    private void initUser() {
        User user = new User();
        user.setEmail("johnrambo@gmail.com");
        user.setName("John Rambo");
        user.setPassword("12345678");
        User use2 = new User();
        use2.setEmail("example@gmail.com");
        use2.setName("example");
        use2.setPassword("12345678");

        user = userRepository.save(user);
        use2 = userRepository.save(use2);


        Flashcard flashcard1 =  new Flashcard();
        flashcard1.setTitle("English");
        flashcard1.setDescription("Words to the exam");
        flashcard1.setFlashcards(55);
        flashcard1.setKnowsFlashcards(20);
        flashcard1.setUser(user);
        Flashcard flashcard2 =  new Flashcard();
        flashcard2.setTitle("German");
        flashcard2.setDescription("Words to the exam");
        flashcard2.setFlashcards(20);
        flashcard2.setKnowsFlashcards(5);
        flashcard2.setUser(user);
        List<Flashcard> flashcardList1 = new ArrayList<>();
        flashcardList1.add(flashcard1);
        flashcardList1.add(flashcard2);
        user.setFlashcards(flashcardList1);
        flashCardRepository.save(flashcard1);
        flashCardRepository.save(flashcard2);


//        for(int i = 0; i < 10; i++){
//
//            Flashcard flashCard =  new Flashcard();
//            flashCard.setTitle("Flashcard" + i);
//            flashCard.setDescription("Words to the exam");
//            flashCard.setFlashcards(55);
//            flashCard.setKnowsFlashcards(20);
//            flashCardRepository.save(flashCard);
//        }
    }

    private void initFlashCards()
    {

    }
}


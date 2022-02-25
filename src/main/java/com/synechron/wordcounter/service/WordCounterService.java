package com.synechron.wordcounter.service;

import com.synechron.wordcounter.model.WordCount;
import com.synechron.wordcounter.repository.DataRetrievalException;
import com.synechron.wordcounter.repository.PersistenceFailedException;
import com.synechron.wordcounter.repository.WordCounterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.synechron.wordcounter.service.Require.requireNonNull;

@Service
public class WordCounterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordCounterService.class);
    @Autowired
    private final WordCounterRepository wordCounterRepository;
    @Autowired
    private final WordTranslatorService wordTranslatorService;


    public WordCounterService(WordCounterRepository wordCounterRepository, WordTranslatorService wordTranslatorService) {
        this.wordCounterRepository = wordCounterRepository;
        this.wordTranslatorService = wordTranslatorService;
    }

    public WordCount add(String word) {

        requireNonNull(word, "word cannot be null");

        WordCount wordCount = null;
        try {
            wordCount = wordCounterRepository.add(word, wordTranslatorService.translate(word));

        } catch (TranslationFailedException | PersistenceFailedException e) {
            LOGGER.error(e.getMessage());
        }
        return wordCount;
    }

    public Optional<WordCount> get(String word) {

        requireNonNull(word, "word cannot be null");
        try {
            return wordCounterRepository.findBy(word);
        } catch (DataRetrievalException e) {
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    public List<WordCount> getAll() {
        try {
            return wordCounterRepository.findAll();
        } catch (DataRetrievalException e) {
            LOGGER.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    public void hello() {
        System.out.println("Hello from WordCounter Service");
    }

}

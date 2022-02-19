/*
package com.synechron.wordcounter.repository;

import com.synechron.wordcounter.model.WordCount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class WordCounterRepositoryTest {

    private WordCounterRepository repository;
    @BeforeEach
    void setUp() {
        repository = new WordCounterRepository();
    }

    @Test
    void add() throws PersistenceFailedException {
        WordCount wordCount = stubExpected();
        when(repository.add(any())).thenReturn(wordCount);
        WordCount response = repository.add("example");
        assertNotNull(response);
        assertEquals("example", response.getWord());
        assertEquals(1, 1);
    }

    @Test
    void findBy() throws DataRetrievalException {
        WordCount wordCount = stubExpected();
        when(repository.findBy("some")).thenReturn(Optional.of(wordCount));
        Optional<WordCount> response = repository.findBy("example");
        assertNotNull(response);
        assertTrue(response.isPresent());
    }

    @Test
    void findAll() {
    }


    private WordCount stubExpected() {
        return WordCount.of("example", 1L);
    }
}*/

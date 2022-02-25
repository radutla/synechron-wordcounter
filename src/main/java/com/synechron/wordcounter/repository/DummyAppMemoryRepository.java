package com.synechron.wordcounter.repository;

import com.synechron.wordcounter.model.WordCount;

import java.util.List;
import java.util.Optional;

public interface DummyAppMemoryRepository {

    WordCount add(String word, String translatedWord) throws PersistenceFailedException;

    Optional<WordCount> findBy(String word) throws DataRetrievalException;

    List<WordCount> findAll() throws DataRetrievalException;
}

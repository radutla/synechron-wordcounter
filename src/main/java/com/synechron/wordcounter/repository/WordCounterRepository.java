package com.synechron.wordcounter.repository;

import com.synechron.wordcounter.model.WordCount;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class WordCounterRepository implements DummyAppMemoryRepository {

    private final static ConcurrentMap<String, CopyOnWriteArrayList<String>> existingWordData = new ConcurrentHashMap<>();

    @Override
    public WordCount add(String word, String translatedWord) throws PersistenceFailedException {

        if (existingWordData.containsKey(translatedWord)) {
            existingWordData.get(translatedWord).add(word);
        } else {
            CopyOnWriteArrayList<String> words = new CopyOnWriteArrayList<String>();
            words.add(translatedWord);
            existingWordData.put(translatedWord, words);
        }
        return new WordCount(word, (long) existingWordData.get(translatedWord).size());
    }

    @Override
    public Optional<WordCount> findBy(String word) throws DataRetrievalException {
        List<String> occurrence = existingWordData.get(word);
        WordCount wordCount = null;
        if (occurrence != null) {
            wordCount = new WordCount(word, (long) occurrence.size());
        }
        return Optional.ofNullable(wordCount);
    }

    @Override
    public List<WordCount> findAll() throws DataRetrievalException {
        return existingWordData.entrySet().stream()
                .map(entry -> new WordCount(entry.getKey(), (long) entry.getValue().size())).collect(Collectors.toList());
    }

}

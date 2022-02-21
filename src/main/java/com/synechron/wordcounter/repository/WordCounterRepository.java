package com.synechron.wordcounter.repository;

import com.synechron.wordcounter.model.WordCount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Repository
public class WordCounterRepository implements DummyAppMemoryRepository {

    private ConcurrentMap<String, Long> existingWordData;

    public WordCounterRepository() {
        WordCountDataConfig wordCountDataConfig = WordCountDataConfig.getInstance();
        this.existingWordData = wordCountDataConfig.getConcurrentMap();
    }

    @Override
    public WordCount add(String word) throws PersistenceFailedException {

        Long occurrence = 1L;
        if (existingWordData.containsKey(word)) {
            occurrence = existingWordData.get(word) + 1;
            existingWordData.put(word, occurrence);
        } else {
            existingWordData.put(word, occurrence);
        }
        return new WordCount(word, occurrence);
    }

    @Override
    public Optional<WordCount> findBy (String word) throws DataRetrievalException {
        Long occurrence = existingWordData.get(word);
        WordCount wordCount = null;
        if(occurrence != null){
            wordCount = new WordCount(word, occurrence);
        }
        return Optional.ofNullable(wordCount);
    }

    @Override
    public List<WordCount> findAll() throws DataRetrievalException{
        return existingWordData.entrySet().stream()
                .map(entry -> new WordCount(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

}

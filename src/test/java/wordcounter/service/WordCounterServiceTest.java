package wordcounter.service;

import com.synechron.wordcounter.model.WordCount;
import com.synechron.wordcounter.repository.DataRetrievalException;
import com.synechron.wordcounter.repository.PersistenceFailedException;
import com.synechron.wordcounter.repository.WordCounterRepository;
import com.synechron.wordcounter.service.WordCounterService;
import com.synechron.wordcounter.service.WordTranslatorService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(JUnit4.class)
public class WordCounterServiceTest {

    private WordCounterService wordCounterService;
    private WordCounterRepository repository;

    @Before
    public void setup() {
        repository = mock(WordCounterRepository.class);
        WordTranslatorService wordTranslatorService = mock(WordTranslatorService.class);
        wordCounterService = new WordCounterService(repository, wordTranslatorService);
    }


    public void testAddSuccess() throws PersistenceFailedException {
        WordCount wordCount = stubExpected();
        when(repository.add("nom", "name")).thenReturn(wordCount);
        WordCount response = wordCounterService.add("example");
        assertNotNull(response);
        assertEquals("example", response.getWord());
        assertEquals(1, 1);
    }

    @org.junit.Test
    public void testAddFailure() throws PersistenceFailedException {
        when(repository.add(null, null)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            wordCounterService.add(null);
        });
    }

    @org.junit.Test
    public void testGetSuccess() throws DataRetrievalException {
        WordCount wordCount = stubExpected();
        when(repository.findBy(any(String.class))).thenReturn(Optional.of(wordCount));
        Optional<WordCount> response = wordCounterService.get("example");
        assertNotNull(response);
        assertTrue(response.isPresent());
    }

    @org.junit.Test
    public void testGetFailure() throws DataRetrievalException {
        when(repository.findBy(null)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            wordCounterService.get(null);
        });
    }

    @org.junit.Test
    public void testGetNoData() throws DataRetrievalException {
        WordCount wordCount = stubExpected();
        when(repository.findBy("notexists")).thenReturn(Optional.empty());
        assertFalse(wordCounterService.get("not").isPresent());

    }

    @org.junit.Test
    public void testGetAllSuccess() throws DataRetrievalException {
        WordCount wordCount = stubExpected();
        when(repository.findAll()).thenReturn(Collections.singletonList(wordCount));
        List<WordCount> response = wordCounterService.getAll();
        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @org.junit.Test
    public void testGetAllNoData() throws DataRetrievalException {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(wordCounterService.getAll().isEmpty());
    }


    private WordCount stubExpected() {
        return WordCount.of("example", 1L);
    }

}
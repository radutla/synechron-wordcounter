package wordcounter.service;

import com.synechron.wordcounter.service.WordValidator;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

class WordValidatorTest {


    @Test
    public void testIsValidWordShouldHandleNull() {
        assertFalse(WordValidator.isValidWord((null)));
    }

    @Test
    public void testIsValidWordEmptyString() {
        assertFalse(WordValidator.isValidWord(("")));
    }

    @Test
    public void testIsValidWordShouldTrimWhiteSpace() {
        assertFalse(WordValidator.isValidWord("  spaces   "));
    }

    @Test
    void testIsValidWordSuccess() {
        assertTrue(WordValidator.isValidWord("word"));
    }

    @Test
    public void testIsAlphaShouldHandleNull() {
        assertFalse(WordValidator.isAlpha((null)));
    }

    @Test
    public void testIsAlphaEmptyString() {
        assertFalse(WordValidator.isAlpha(("")));
    }

    @Test
    public void testIsAlphaShouldTrimWhiteSpace() {
        assertFalse(WordValidator.isAlpha("  spaces   "));
    }

    @Test
    void testIsAlphaWordSuccess() {
        assertTrue(WordValidator.isValidWord("word"));
    }


}
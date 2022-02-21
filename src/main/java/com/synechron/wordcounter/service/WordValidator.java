package com.synechron.wordcounter.service;

import org.springframework.stereotype.Component;

@Component
public class WordValidator {

    public static boolean isValidWord(String word) {
        return isNotNullAndEmpty(word) && isAlpha(word);
    }

    private static boolean isNotNullAndEmpty(String word) {
        return word != null && !word.trim().isEmpty();
    }

    public static boolean isAlpha(String word) {
        return isNotNullAndEmpty(word) && word.matches("^[a-zA-Z]*$");
    }
}

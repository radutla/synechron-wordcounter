package com.synechron.wordcounter.model;

public class WordCount {

    private String word;
    private Long occurrence;

    public WordCount(String word, Long occurrence) {
        this.word = word;
        this.occurrence = occurrence;
    }

    public static WordCount of(String value, Long occurrence)
    {
        return new WordCount(value, occurrence);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Long occurrence) {
        this.occurrence = occurrence;
    }
}

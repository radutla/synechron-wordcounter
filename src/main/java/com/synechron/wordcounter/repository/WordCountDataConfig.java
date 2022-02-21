package com.synechron.wordcounter.repository;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordCountDataConfig {

    private ConcurrentMap<String, Long> concurrentMap;
    private static WordCountDataConfig instance;
    private static final Object mutex = new Object();


    private WordCountDataConfig() { }

    public static WordCountDataConfig getInstance() {
        WordCountDataConfig result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new WordCountDataConfig();
            }
        }
        return result;
    }



    public ConcurrentMap<String, Long> getConcurrentMap() {
        if(concurrentMap == null)
            setConcurrentMap();
        return concurrentMap;
    }

    private void setConcurrentMap() {
        this.concurrentMap = new ConcurrentHashMap<>();
    }

}

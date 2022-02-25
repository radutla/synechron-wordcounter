/*
package com.synechron.wordcounter.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordCountDataConfig {

    private static final Object mutex = new Object();
    private static WordCountDataConfig instance;
    private ConcurrentMap<String, Long> concurrentMap;

    private WordCountDataConfig() {
    }

    public static WordCountDataConfig getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null)
                    instance = new WordCountDataConfig();
            }
        }
        return instance;
    }


    public ConcurrentMap<String, Long> getConcurrentMap() {
        if (concurrentMap == null)
            setConcurrentMap();
        return concurrentMap;
    }

    private void setConcurrentMap() {
        this.concurrentMap = new ConcurrentHashMap<>();
    }

}
*/

package com.synechron.wordcounter.repository;

public class DataRetrievalException extends Exception {
    public DataRetrievalException(String errorMessage) { super("database error =" + errorMessage); }

}

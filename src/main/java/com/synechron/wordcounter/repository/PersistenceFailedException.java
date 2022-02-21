package com.synechron.wordcounter.repository;

public class PersistenceFailedException extends Exception {

    public PersistenceFailedException(String errorMessage) { super("error=" + errorMessage); }
}

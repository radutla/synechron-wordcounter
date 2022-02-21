package com.synechron.wordcounter.service;

public class RequiredParamException extends Exception {
    public RequiredParamException(int errorCode) {
        super("error=" + errorCode);
    }
}

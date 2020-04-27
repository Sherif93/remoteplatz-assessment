package com.remoteplatz.assessment.exception;

public class DuplicateCategoryException extends RuntimeException {

    public DuplicateCategoryException() {
        super("Error:duplicate Categories");
    }

    public DuplicateCategoryException(String message) {
        super(message);
    }
}

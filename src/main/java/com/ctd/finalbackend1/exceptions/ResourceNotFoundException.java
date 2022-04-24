package com.ctd.finalbackend1.exceptions;

/**
 * ResourceNotFoundException.
 * is thrown when a resource is not found within the database trying to delete it.
 * contains a message
* */
public class ResourceNotFoundException extends Exception{
    private static final String MESSAGE = "ID not found";
    public ResourceNotFoundException() {
        super(MESSAGE);
    }
}

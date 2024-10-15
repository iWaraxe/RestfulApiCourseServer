// File: ResourceNotFoundException.java
package com.coherentsolutions.restful.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
package com.intercam.exceptions;

/**
 *
 * @author Luis.Bonifaz
 */
public class CustomExceptions extends RuntimeException {
    
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    
    public static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) {
            super(message);
        }
    }
    
}

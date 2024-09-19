package com.intercam.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Luis.Bonifaz
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(ResourceNotFoundException ex) {
        LOGGER.error(ex);
        Map<String, Object> body = new HashMap<>();
        body.put("message", "No se encontraron resultados");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
}

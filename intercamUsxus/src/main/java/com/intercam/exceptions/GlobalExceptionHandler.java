package com.intercam.exceptions;

import static com.intercam.util.Constantes.MENSAJE;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Luis.Bonifaz
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    @ExceptionHandler(CustomExceptions.ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(CustomExceptions.ResourceNotFoundException ex) {
        LOGGER.error(ex);
        Map<String, Object> body = new HashMap<>();
        body.put(MENSAJE, "No se encontraron resultados");
        body.put("error", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        LOGGER.error(ex);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        LOGGER.error(ex);
        Map<String, Object> body = new HashMap<>();
        body.put(MENSAJE, "Ocurrió un error inesperado");
        body.put("error", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}

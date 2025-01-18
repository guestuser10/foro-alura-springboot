package com.foro.foro.infrastructure.errores;

import jakarta.persistence.EntityNotFoundException;
import com.foro.foro.domain.ValidacionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handle404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(datosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }
    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<?> tratarErrorDeValidacion(ValidacionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record datosErrorValidacion(String campo, String mensaje) {
        public datosErrorValidacion(org.springframework.validation.FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

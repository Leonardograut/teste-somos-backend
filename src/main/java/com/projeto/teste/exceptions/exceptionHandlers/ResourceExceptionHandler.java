package com.projeto.teste.exceptions.exceptionHandlers;

import com.projeto.teste.exceptions.ConsultaNotFoundException;
import com.projeto.teste.exceptions.MedicoNotFoundException;
import com.projeto.teste.exceptions.PacienteNotFountException;
import com.projeto.teste.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(PacienteNotFountException.class)
    public ResponseEntity<StandardError> pacienteNotFoundException(PacienteNotFountException ex , HttpServletRequest request){

        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
    @ExceptionHandler(MedicoNotFoundException.class)
    public ResponseEntity<StandardError> medicoNotFoundException(MedicoNotFoundException ex , HttpServletRequest request){

        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(ConsultaNotFoundException.class)
    public ResponseEntity<StandardError> consultaNotFoundException(ConsultaNotFoundException ex , HttpServletRequest request){

        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }


}

package io.github.tsrangel.mscreditassessor.application.exceptionsHandler;

import io.github.tsrangel.mscreditassessor.application.exceptionsHandler.errors.StandartError;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.ClientDataNotFoundException;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.FeignClientConnectionError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptionHandler {
    @ExceptionHandler(ClientDataNotFoundException.class)
    public ResponseEntity<StandartError> notFoundError(ClientDataNotFoundException e,
                                                       HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StandartError(
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        ));
    }

    @ExceptionHandler(FeignClientConnectionError.class)
    public ResponseEntity<StandartError> connectionError(FeignClientConnectionError e,
                                                       HttpServletRequest request) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return ResponseEntity.status(status).body(new StandartError(
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        ));
    }
}

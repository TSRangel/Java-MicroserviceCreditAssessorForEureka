package io.github.tsrangel.mscreditassessor.application.exceptionsHandler.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record StandartError(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss'Z'", timezone = "GMT-3")
        Instant timestamp,
        Integer status,
        String message,
        String path
) {
    public StandartError(Integer status, String message, String path) {
        this(Instant.now(), status, message, path);
    }
}

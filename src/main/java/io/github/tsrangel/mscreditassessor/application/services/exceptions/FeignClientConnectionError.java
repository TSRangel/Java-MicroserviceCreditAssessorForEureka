package io.github.tsrangel.mscreditassessor.application.services.exceptions;

import lombok.Getter;

public class FeignClientConnectionError extends Exception {
    @Getter
    private Integer statusCode;

    public FeignClientConnectionError(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}

package com.example.demo.exception;


import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
public class AppException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String code;
    private final String message;
    private final transient Object data;

    public AppException(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = message;
    }

    public AppException(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

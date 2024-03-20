package com.example.demo.exception;

public class QueueMessageException extends AppException {
    public QueueMessageException(String code, String message) {
        super(code, message);
    }

    public QueueMessageException(String code, String message, Object data) {
        super(code, message, data);
    }
}

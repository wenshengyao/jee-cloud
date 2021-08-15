package xyz.jee.frame.base.exception;

import lombok.Data;

@Data
public class BusinessRuntimeException extends RuntimeException {
    private String message;
    public BusinessRuntimeException(String message) {
        this.message = message;
    }


}

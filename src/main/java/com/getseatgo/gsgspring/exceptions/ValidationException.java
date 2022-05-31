package com.getseatgo.gsgspring.exceptions;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;

    public ValidationException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}

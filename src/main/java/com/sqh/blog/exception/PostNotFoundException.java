package com.sqh.blog.exception;

public class PostNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6792633626184353183L;

    public PostNotFoundException() {
        super();
    }

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PostNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

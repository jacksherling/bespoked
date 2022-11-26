package com.jack.bespoked.util;

public class Response {

    private String message;
    private Object data;

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

}
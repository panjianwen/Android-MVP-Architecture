package com.lingtu.study.net;

/**
 * Created by pan on 2019/5/5.
 */
public class ResultException extends RuntimeException {
    private int code;
    private String message;

    public ResultException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

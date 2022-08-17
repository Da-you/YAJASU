package com.sparta.prac.exception;

import org.springframework.http.HttpStatus;

public class RestApiException {
    private String errorMessage;
    private HttpStatus httpStatus;

    public RestApiException() {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    //Setter
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    //Getter
    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

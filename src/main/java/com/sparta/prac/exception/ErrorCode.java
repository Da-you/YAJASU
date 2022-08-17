package com.sparta.prac.exception;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // 400 Bad Request
    PASSWORD_NOT_EQUALS(HttpStatus.BAD_REQUEST, "400", "비밀번호가 일치하지 않습니다.");
    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}

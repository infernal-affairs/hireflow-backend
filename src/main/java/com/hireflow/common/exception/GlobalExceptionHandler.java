package com.hireflow.common.exception;

import com.hireflow.common.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //指定下方法专门接收BusinessException
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e){
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<Void> body = ApiResponse.failure(errorCode, e.getMessage());
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(body);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ErrorCode errorCode = ErrorCode.INVALID_PARAM;
        String message = errorCode.getMessage();
        FieldError fieldError = e.getBindingResult().getFieldError();
        if(fieldError != null){
            message = fieldError.getField() + ":"
                    + fieldError.getDefaultMessage();
        }
        ApiResponse<Void> body = ApiResponse.failure(errorCode, message);
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(body);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Void>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        ErrorCode errorCode = ErrorCode.INVALID_PARAM;
        String message = "请求体格式错误";
        ApiResponse<Void> body = ApiResponse.failure(errorCode, message);
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(body);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e){
        log.error("未处理的异常", e);
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        String message = errorCode.getMessage();
        ApiResponse<Void> body = ApiResponse.failure(errorCode, message);
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(body);
    }
}

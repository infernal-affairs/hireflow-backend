package com.hireflow.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    INVALID_PARAM(1001 , "参数校验失败" , HttpStatus.BAD_REQUEST),
    UNAUTHORIZED( 1002 , "未登录或过期" , HttpStatus.UNAUTHORIZED ),
    FORBIDDEN( 1003 , "无权限执行此操作" , HttpStatus.FORBIDDEN ),
    NOT_FOUND( 1004, "请求的资源不存在" , HttpStatus.NOT_FOUND ),
    CONFLICT( 1005, "数据冲突" ,  HttpStatus.CONFLICT ),
    INTERNAL_ERROR( 5000, "服务器内部错误" , HttpStatus.INTERNAL_SERVER_ERROR );

    ErrorCode(int code, String msg, HttpStatus httpStatus) {
        this.code = code;
        this.message = msg;
        this.httpStatus = httpStatus;
    }
    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

}

package com.hireflow.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiResponse<T> {
    private final int code;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success (T data){
        return new ApiResponse<>(0,"success",data);
    }
    public static ApiResponse<Void> success (){
        return new ApiResponse<>(0,"success",null);
    }
}

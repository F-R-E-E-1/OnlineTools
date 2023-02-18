package com.onlinetool.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

//转为JSON，为null不序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor//全参构造器
@Data
public class ServerResponse<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    private ServerResponse(int code){
        this.code = code;
    }
    private ServerResponse(int code,T data){
        this.data = data;
    }
    private ServerResponse(int code,String message){
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ServerResponse<T> createSuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMessage(String message){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T> ServerResponse<T> createSuccessData(T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createSuccessData(String message,T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),message,data);
    }

    public static <T> ServerResponse<T> createError(){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createError(String errorMessage){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createError(int code,String errorMessage){
        return new ServerResponse<>(code,errorMessage);
    }

}

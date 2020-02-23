package com.example.demo.config.baseConfig;

import lombok.Data;

/**
 * http请求最外层对象,统一返回接口
 * @param <T>
 */
@Data
public class Result<T> {
    //返回码
    private Integer code;
    //提示信息
    private String msg;
    //返回具体内容
    private T data;
}

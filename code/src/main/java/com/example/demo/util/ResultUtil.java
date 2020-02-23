package com.example.demo.util;

import com.example.demo.config.baseConfig.Result;
import com.example.demo.config.baseConfig.ResultEnum;
import com.example.demo.config.exceptionHandle.UserException;

/**
 * 统一返回接口的工具类
 */
public class ResultUtil {
    /**
     * 返回正确结果，且带有返回内容
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        return success(ResultEnum.SUCCESS.getMsg(), object);
    }

    /**
     * 返回正确结果，自定义msg和数据
     *
     * @return
     */
    public static Result success(String msg, Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    /**
     * 返回正确结果，没有返回内容
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 返回错误结果
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static Result error(UserException userException) {
        return error(userException.getCode(), userException.getMessage());
    }
}


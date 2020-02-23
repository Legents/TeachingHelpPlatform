package com.example.demo.config.exceptionHandle;

import com.example.demo.config.baseConfig.Result;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.error(userException);
        }

        return ResultUtil.error(-1, e.getMessage());
    }
}

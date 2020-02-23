package com.example.demo.config.exceptionHandle;

import com.example.demo.config.baseConfig.ResultEnum;
import lombok.Data;

@Data
public class UserException extends RuntimeException {
    private Integer code;

    public UserException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }
}

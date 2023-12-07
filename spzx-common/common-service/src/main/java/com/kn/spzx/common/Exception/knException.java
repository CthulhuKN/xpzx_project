package com.kn.spzx.common.Exception;

import com.kn.spzx.model.vo.common.ResultCodeEnum;
import lombok.Data;

//自定义异常
@Data
public class knException extends RuntimeException {

    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public knException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

}

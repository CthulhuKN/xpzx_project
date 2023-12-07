package com.kn.spzx.common.Exception;

import com.kn.spzx.model.vo.common.Result;
import com.kn.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice controller增强器对controller进行从医管理
@ControllerAdvice
public class GlobalExceptionHandler {
    //全局异常处理
    @ExceptionHandler(Exception.class)//出现异常时会执行
    @ResponseBody
    public Result error() {
        return Result.build(null, ResultCodeEnum.DATA_ERROR);
    }

    //自定义异常
    @ExceptionHandler(knException.class)
    @ResponseBody
    public Result error(knException e) {
        return Result.build(null, e.getResultCodeEnum());
    }


}

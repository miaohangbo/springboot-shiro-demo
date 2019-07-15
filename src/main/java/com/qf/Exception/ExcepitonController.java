package com.qf.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by 54110 on 2019-07-13.
 */
@ControllerAdvice //controller增强
public class ExcepitonController {

    @ExceptionHandler(Exception.class)
    public String exceptionHandle(){
        return "redirect:unath";
    }
}

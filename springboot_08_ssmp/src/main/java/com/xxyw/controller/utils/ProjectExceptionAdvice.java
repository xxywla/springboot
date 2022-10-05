package com.xxyw.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R dealException(Exception ex) {
        ex.printStackTrace();
        return new R("系统错误，请稍后再试");
    }
}

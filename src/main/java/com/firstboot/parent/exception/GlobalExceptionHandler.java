package com.firstboot.parent.exception;

import com.firstboot.parent.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiong on 2018/5/16.
 */

@ControllerAdvice  //定义统一的异常处理类
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandle(HttpServletRequest request,Exception e )throws Exception{
        ModelAndView mv=new ModelAndView();
        mv.addObject("exception",e);
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,MyException me){

        ErrorInfo<String> r = new ErrorInfo();
        r.setMessage(me.getMessage());
        r.setCode(ErrorInfo.getERROR());
        r.setData("这是一个错误哦错误错误哦");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }



}

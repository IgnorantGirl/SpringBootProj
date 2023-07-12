package com.hui.springbootproj.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

// ControllerAdvice 会拦截标注controller的所有控制器
@ControllerAdvice
public class ControllerExceptionHandler {

    // 将异常记录到日志中
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理异常 信息  ExceptionHandler标识该方法可以做异常处理的
     * @param request  访问的url
     * @param e 异常
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
        // 记录异常信息：请求的URL，异常信息
        logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(),e);

        // 当标识了状态码的时候就不拦截  直接抛出异常,比如异常找不到
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        // 将记录的异常信息返回到error页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}

package com.shaochen.swaggerdemo.common.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author JiShaochen
 * @date 2018/8/30 11:17
 * @desc 异常拦截.
 */
@RestControllerAdvice(basePackages = "com.shaochen.swaggerdemo.rest")
public class ExceptionFilter {

    @Resource
    ExceptionManager exceptionManager;

    @Value("${appIp}")
    private String ip;

    @Value("${appName}")
    private String appName;

    /**
     * 校验异常
     * @param e
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String handlerException(ConstraintViolationException e) {
        String code = e.getConstraintViolations().stream().limit(1).map(vio -> vio.getMessageTemplate())
                .collect(Collectors.toList()).get(0);
        FatherException exception = exceptionManager.createByCode(code);
        exception.setStackTrace(e.getStackTrace());

        FatherException phantomException = exceptionManager.create(exception);
        return phantomException.toString();
    }

    /**
     * 如果是自定义异常
     * @param e
     */
    @ExceptionHandler(FatherException.class)
    public String handlerException(FatherException e) {
        FatherException phantomException = exceptionManager.create(e);
        return phantomException.toString();
    }



    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        FatherException exception = new FatherException(UUID.randomUUID().toString().replace("-", ""), appName, ip, "SYSTEM_ERR", e.getMessage());
        exception.setStackTrace(e.getStackTrace());
        FatherException phantomException = exceptionManager.create(exception);
        return phantomException.toString();
    }


    /**
     * KingBoy实现异常栈信息打印，通过查看源码
     * @param e
     * @return
     */
    private String logTraceInfo(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e);
        for (StackTraceElement traceElement : trace) {
            sb.append("\n\tat " + traceElement);
        }
        return sb.toString();
    }
}
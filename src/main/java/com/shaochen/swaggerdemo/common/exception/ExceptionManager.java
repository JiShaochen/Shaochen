package com.shaochen.swaggerdemo.common.exception;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JiShaochen
 * @date 2018/8/30 10:37
 * @desc 异常体系.
 */
@Data
@Component
@PropertySource(value = "exception.properties", encoding = "UTF-8")
public class ExceptionManager {

    @Value("${appIp}")
    private String ip;

    @Value("${appName}")
    private String appName;

    @Resource
    Environment environment;

    public FatherException createByCode(String code) {
        return new FatherException(UUID.randomUUID().toString().replace("-", ""), appName, ip, code, environment.getProperty(code));
    }

    public FatherException createByMessage(String message) {
        return new FatherException(UUID.randomUUID().toString().replace("-", ""), appName, ip, "系统异常", message);
    }

    /**
     * 简化异常栈信息
     * @param pe
     * @return
     */
    protected FatherException create(FatherException pe) {
        List<StackTraceElement> traceList = Stream.of(pe.getStackTrace())
                .filter(p -> p.getClassName().contains("com.maxrocky"))
                .filter(p -> !p.getClassName().contains("$"))
                .filter(p -> !p.getClassName().contains(".exception."))
                .collect(Collectors.toList());
        pe.setStackTrace(traceList.toArray(new StackTraceElement[]{}));
        return pe;
    }
}
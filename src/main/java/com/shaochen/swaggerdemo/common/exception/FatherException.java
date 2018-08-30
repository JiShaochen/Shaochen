package com.shaochen.swaggerdemo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiShaochen
 * @date 2018/8/30 10:38
 * @desc 异常体系类.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatherException extends RuntimeException {

    //异常id
    private String id;

    private String appName;

    private String ip;

    //错误码
    private String code;

    //错误提示信息
    private String msg;

    public String toString(){
        return String.format("{\"appName\":\"%s\",\"code\":\"%s\",\"id\":\"%s\",\"ip\":\"%s\",\"msg\":\"%s\"}",
                this.appName, this.code, this.id, this.ip, this.msg);
    }

}
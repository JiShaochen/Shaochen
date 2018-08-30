package com.shaochen.swaggerdemo.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author JiShaochen
 * @date 2018/8/30 14:19
 * @desc 返回结果.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {
    private String code;
    private String msg;
    private Object data;

    public static ApiResult success(Object data){
        return new ApiResult("200", "", data);
    }

}
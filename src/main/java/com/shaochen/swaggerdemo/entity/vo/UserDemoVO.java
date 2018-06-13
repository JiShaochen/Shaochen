package com.shaochen.swaggerdemo.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author JiShaochen
 * @date 2018/6/13 16:31
 * @desc .
 */
@Data
@AllArgsConstructor
public class UserDemoVO {
    // 用户的名字
    private String name;
    // 用户的地址
    private String address;
    // 用户的年龄
    private Integer age;
    // 用户的电话号
    private String phone;
}
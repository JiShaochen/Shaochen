package com.shaochen.swaggerdemo.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author JiShaochen
 * @date 2018/6/13 20:32
 * @desc .
 */
@Data
@AllArgsConstructor
public class UserDemoPO {
    // 用户的id
    private Integer id;
    // 用户的名字
    private String name;
    // 用户的地址
    private String address;
    // 用户的年龄
    private Integer age;
    // 用户的电话号
    private String phone;
}
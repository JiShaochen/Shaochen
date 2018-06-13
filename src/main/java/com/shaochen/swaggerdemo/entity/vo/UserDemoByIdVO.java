package com.shaochen.swaggerdemo.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author JiShaochen
 * @date 2018/6/13 20:35
 * @desc 根据id查询用户的VO.
 */
@Data
@AllArgsConstructor
public class UserDemoByIdVO {
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
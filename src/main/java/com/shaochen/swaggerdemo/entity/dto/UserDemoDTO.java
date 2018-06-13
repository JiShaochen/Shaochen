package com.shaochen.swaggerdemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author JiShaochen
 * @date 2018/6/13 16:44
 * @desc 用户案例插入请求体.
 */
@Data
@ApiModel
public class UserDemoDTO {

    // 用户的名字
    @ApiModelProperty(name = "小明同学", value = "name", example = "小明同学")
    private String name;
    // 用户的地址
    @ApiModelProperty(name = "黑龙江", value = "address", example = "黑龙江")
    private String address;
    // 用户的年龄
    @ApiModelProperty(name = "18", value = "age", example = "18")
    private Integer age;
    // 用户的电话号
    @ApiModelProperty(name = "13804691613", value = "phone", example = "13504002455")
    private String phone;

}
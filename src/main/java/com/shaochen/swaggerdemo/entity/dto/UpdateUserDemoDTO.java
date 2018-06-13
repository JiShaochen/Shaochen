package com.shaochen.swaggerdemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiShaochen
 * @date 2018/6/13 20:43
 * @desc 修改用户的DTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UpdateUserDemoDTO {
    // 用户的id
    @ApiModelProperty(name = "用户的id", value = "id", example = "1")
    private Integer id;
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
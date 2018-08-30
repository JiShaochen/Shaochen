package com.shaochen.swaggerdemo.rest;

import com.shaochen.swaggerdemo.common.result.ApiResult;
import com.shaochen.swaggerdemo.entity.dto.UpdateUserDemoDTO;
import com.shaochen.swaggerdemo.entity.dto.UserDemoDTO;
import com.shaochen.swaggerdemo.service.UserDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author JiShaochen
 * @date 2018/6/13 15:54
 * @desc 用户案例controller层.
 */
@RestController
@Api(value = "user", tags = {"userDemo"})
@RequestMapping(value = "/user")
public class UserDemoController {

    @Resource
    UserDemoService userService;

    @GetMapping(value = "/test")
    public String testDemo() {
        return "Hello World";
    }

    @ApiOperation(value = "插入用户案例", produces = "application/json")
    @PostMapping
    public ApiResult addUserDemo(@RequestBody UserDemoDTO userDemoDTO) {
        userService.addUserDemo(userDemoDTO);
        return ApiResult.success("ok");
    }

    @ApiOperation(value = "查询一个用户案例", produces = "application/json")
    @GetMapping("/{id}")
    public ApiResult getUserDemo(@PathVariable(value = "id") Integer id) {
        return ApiResult.success(userService.getUserDemo(id));
    }

    @ApiOperation(value = "修改一个用户案例", produces = "application/json")
    @PutMapping
    public ApiResult updateUserDemo(@RequestBody UpdateUserDemoDTO updateDTO) {
        userService.updateUserDemo(updateDTO);
        return ApiResult.success("ok");
    }

    @ApiOperation(value = "删除一个用户案例", produces = "application/json")
    @DeleteMapping("/{id}")
    public ApiResult deleteUserDemo(@PathVariable(value = "id") Integer id ) {
        userService.deleteUserDemo(id);
        return ApiResult.success("ok");
    }

}
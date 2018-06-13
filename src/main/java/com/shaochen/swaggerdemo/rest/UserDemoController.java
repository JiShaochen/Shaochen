package com.shaochen.swaggerdemo.rest;

import com.shaochen.swaggerdemo.entity.dto.UpdateUserDemoDTO;
import com.shaochen.swaggerdemo.entity.dto.UserDemoDTO;
import com.shaochen.swaggerdemo.entity.po.UserDemoPO;
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
    public String addUserDemo(@RequestBody UserDemoDTO userDemoDTO) {
        userService.addUserDemo(userDemoDTO);
        return "ok" ;
    }

    @ApiOperation(value = "查询一个用户案例", produces = "application/json")
    @GetMapping("/{id}")
    public UserDemoPO getUserDemo(@PathVariable(value = "id") Integer id) {
        return userService.getUserDemo(id);
    }

    @ApiOperation(value = "修改一个用户案例", produces = "application/json")
    @PutMapping
    public String updateUserDemo(@RequestBody UpdateUserDemoDTO updateDTO) {
        userService.updateUserDemo(updateDTO);
        return "ok";
    }

    @ApiOperation(value = "删除一个用户案例", produces = "application/json")
    @DeleteMapping("/{id}")
    public String deleteUserDemo(@PathVariable(value = "id") Integer id ) {
        userService.deleteUserDemo(id);
        return "ok";
    }

}
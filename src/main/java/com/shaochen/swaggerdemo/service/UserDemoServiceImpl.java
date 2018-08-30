package com.shaochen.swaggerdemo.service;

import com.shaochen.swaggerdemo.common.exception.ExceptionManager;
import com.shaochen.swaggerdemo.dao.UserDemoMapper;
import com.shaochen.swaggerdemo.dao.UserDemoQueryMapper;
import com.shaochen.swaggerdemo.entity.dto.UpdateUserDemoDTO;
import com.shaochen.swaggerdemo.entity.dto.UserDemoDTO;
import com.shaochen.swaggerdemo.entity.po.UserDemoPO;
import com.shaochen.swaggerdemo.entity.vo.UserDemoByIdVO;
import com.shaochen.swaggerdemo.entity.vo.UserDemoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author JiShaochen
 * @date 2018/6/13 16:28
 * @desc 用户案例实现类.
 */
@Service
public class UserDemoServiceImpl implements UserDemoService {

    @Resource
    UserDemoMapper userMapper;

    @Resource
    UserDemoQueryMapper userDemoQueryMapper;

    @Resource
    ExceptionManager exceptionManager;

    /**
     * @Author: ShaoChen
     * @Description:  插入用户案例
     * @Date: 18:44 2018/6/13
     */
    @Override
    public void addUserDemo(UserDemoDTO userDemoDTO) {
        if (true) {
            throw exceptionManager.createByCode("TH001");
        }
        Integer age = userDemoDTO.getAge();
        String address = userDemoDTO.getAddress();
        String name = userDemoDTO.getName();
        String phone = userDemoDTO.getPhone();
        userMapper.addUserDemo(new UserDemoVO(name, address, age, phone));
    }

    /**
     * @Author: ShaoChen
     * @Description:   查询一个用户案例
     * @Date: 20:33 2018/6/13
     */
    @Override
    public UserDemoPO getUserDemo(Integer id) {
        UserDemoByIdVO userDemoVO = userDemoQueryMapper.getUserDemo(id);
        Integer resultId = userDemoVO.getId();
        Integer age = userDemoVO.getAge();
        String address = userDemoVO.getAddress();
        String name = userDemoVO.getName();
        String phone = userDemoVO.getPhone();
        return new UserDemoPO(resultId, name, address, age, phone);
    }

    /**
     * @Author: ShaoChen
     * @Description:   根据用户id修改用户信息
     * @Date: 20:45 2018/6/13
     */
    @Override
    public void updateUserDemo(UpdateUserDemoDTO updateDTO) {
        Integer id = updateDTO.getId();
        String address = updateDTO.getAddress();
        Integer age = updateDTO.getAge();
        String name = updateDTO.getName();
        String phone = updateDTO.getPhone();
        userMapper.updateUserDemo(new UserDemoByIdVO(id, name, address, age, phone));
    }

    /**
     * @Author: ShaoChen
     * @Description:   删除用户案例
     * @Date: 21:02 2018/6/13
     */
    @Override
    public void deleteUserDemo(Integer id) {
        userMapper.deleteUserDemo(id);
    }
}
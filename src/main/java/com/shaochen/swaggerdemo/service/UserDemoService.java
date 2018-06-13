package com.shaochen.swaggerdemo.service;

import com.shaochen.swaggerdemo.entity.dto.UpdateUserDemoDTO;
import com.shaochen.swaggerdemo.entity.dto.UserDemoDTO;
import com.shaochen.swaggerdemo.entity.po.UserDemoPO;

public interface UserDemoService {
    void addUserDemo(UserDemoDTO userDemoDTO);

    UserDemoPO getUserDemo(Integer id);

    void updateUserDemo(UpdateUserDemoDTO updateDTO);

    void deleteUserDemo(Integer id);
}

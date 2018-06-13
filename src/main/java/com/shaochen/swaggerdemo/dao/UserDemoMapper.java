package com.shaochen.swaggerdemo.dao;

import com.shaochen.swaggerdemo.entity.dto.UserDemoDTO;
import com.shaochen.swaggerdemo.entity.vo.UserDemoByIdVO;
import com.shaochen.swaggerdemo.entity.vo.UserDemoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @Author: ShaoChen
 * @Description:   用户案例mapper层
 * @Date: 16:29 2018/6/13
 */
public interface UserDemoMapper {
    @Insert("INSERT INTO `user` (`name`, `age`, `address`, `phone`) VALUES (#{name}, #{age}, #{address}, #{phone});")
    void addUserDemo(UserDemoVO userDemoVo);

    @Select("SELECT * from `user` where id = #{id}")
    UserDemoByIdVO getUserDemo(@Param("id") Integer id);

    @Update("UPDATE `user` SET `name` = #{name}, age = #{age}, address = #{address}, phone = #{phone} WHERE id = #{id}")
    void updateUserDemo(UserDemoByIdVO userDemoByIdVO);

    @DeleteMapping("DELETE FROM `user` WHERE id = #{id}")
    void deleteUserDemo(@Param("id") Integer id);
}

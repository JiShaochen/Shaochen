package com.shaochen.swaggerdemo.dao;

import com.shaochen.swaggerdemo.entity.vo.UserDemoByIdVO;
import com.shaochen.swaggerdemo.entity.vo.UserDemoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author JiShaochen
 * @date 2018/8/30 14:12
 * @desc 茶水呢.
 */
public interface UserDemoQueryMapper {
    @Select("SELECT * from `user` where id = #{id}")
    UserDemoByIdVO getUserDemo(@Param("id") Integer id);
}
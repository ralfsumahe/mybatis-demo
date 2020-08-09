package com.lk.mybatis.dao;

import com.lk.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User getUserByName(String name);


}

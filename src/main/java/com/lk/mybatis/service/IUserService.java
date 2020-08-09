package com.lk.mybatis.service;

import com.lk.mybatis.dao.UserMapper;
import com.lk.mybatis.pojo.User;

public interface IUserService {
    public User getUserById(Integer id);
    public User getUserByName(String name);
    public Integer saveUser(User user);
}

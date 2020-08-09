package com.lk.mybatis.controller;

import com.lk.mybatis.pojo.User;
import com.lk.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/userbyname")
    public User getUserByName(String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/user")
    public Integer saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}

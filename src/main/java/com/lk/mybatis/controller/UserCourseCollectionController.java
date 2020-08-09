package com.lk.mybatis.controller;

import com.lk.mybatis.pojo.UserCourseCollection;
import com.lk.mybatis.service.UserCourseCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("收藏")
@RequestMapping("/collect")
public class UserCourseCollectionController {
    @Autowired
    private UserCourseCollectionService userCourseCollectionService;

    @GetMapping("/get/{id}")
    public UserCourseCollection get(@PathVariable("id") Integer id){
        return userCourseCollectionService.get(id);
    }

    @ApiOperation("收藏")
    @PostMapping("/add")
    @CachePut(value = "collection",key = "#result.id")
    public UserCourseCollection addCollection(@RequestBody UserCourseCollection userCourseCollection){
        return userCourseCollectionService.addCollection(userCourseCollection);
    }

    @ApiOperation("取消收藏")
    @PostMapping("/cacel")
    @CacheEvict(value = "collection",key = "#result")
    public Integer cancelCollection(@RequestBody UserCourseCollection userCourseCollection){
        return userCourseCollectionService.cancelCollection(userCourseCollection);
    }

    @ApiOperation("分页查找收藏")
    @PostMapping("/find")
    public List<UserCourseCollection> findPageByUserId(Integer userId,Integer offset,Integer limit){
        return userCourseCollectionService.findPageByUserId(userId, offset, limit);
    }


}

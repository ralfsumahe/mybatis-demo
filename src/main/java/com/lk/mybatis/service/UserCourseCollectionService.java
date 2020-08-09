package com.lk.mybatis.service;

import com.lk.mybatis.dao.UserCourseCollectionMapper;
import com.lk.mybatis.pojo.UserCourseCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserCourseCollectionService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserCourseCollectionMapper userCourseCollectionMapper;

    @Cacheable(value = "collection",key = "#p0")
    public UserCourseCollection get(Integer id){
        return userCourseCollectionMapper.selectByPrimaryKey(id);
    }


    @Cacheable(value = "collection", key ="#result.userId+'-'+#result.courseId")
    public UserCourseCollection getByUserIdAndCourseId(Integer userId,Integer courseId){
        UserCourseCollection queryByUserIdCourseId = UserCourseCollection.builder().userId(userId).courseId(courseId).build();
        return userCourseCollectionMapper.selectOne(queryByUserIdCourseId);
    }

    @Caching(
            put = {
                    @CachePut(value = "collection",key ="#result.id"),
                    @CachePut(value = "collection",key ="#p0.userId+'_'+#p0.courseId")
            }
    )

    public UserCourseCollection addCollection(UserCourseCollection params){
        UserCourseCollection userCourseCollection = getByUserIdAndCourseId(params.getUserId(), params.getCourseId());
        if(userCourseCollection == null){
            userCourseCollectionMapper.insert(params);
            return params;
        }else{
            return userCourseCollection;
        }
    }

    @Caching(
        evict = {
            @CacheEvict(value = "collection",key = "#p0.userId+'-'+#p0.courseId"),
            @CacheEvict(value = "collection",key = "#result")
        }
    )
    public Integer cancelCollection(UserCourseCollection params){
        Integer id = 0;

        UserCourseCollection userCourseCollection = getByUserIdAndCourseId(params.getUserId(), params.getCourseId());

        if(userCourseCollection != null){
            userCourseCollectionMapper.delete(userCourseCollection);
            id = userCourseCollection.getId();
        }

        Set<String> keys = stringRedisTemplate.keys("collection::"+params.getUserId()+"_*");
        stringRedisTemplate.delete(keys);

        return id;
    }

    @Cacheable(value = "collection",key = "#p0+'_'+#p1+'_'+#p2")
    public List<UserCourseCollection> findPageByUserId(Integer userId,Integer offset,Integer limit){
        return userCourseCollectionMapper.findPageByUserId(userId, offset, limit);
    }
}

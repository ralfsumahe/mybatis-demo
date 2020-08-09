package com.lk.mybatis.dao;

import com.lk.mybatis.pojo.UserCourseCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface UserCourseCollectionMapper extends BaseMapper<UserCourseCollection> {
    @Select("select id id,user_id userId,course_id courseId from user_course_collection t where t.user_id = #{userId} limit #{offset},#{limit}")
    public List<UserCourseCollection> findPageByUserId(@Param("userId") Integer userId,
             @Param("offset") Integer offset,@Param("limit") Integer limit);
}

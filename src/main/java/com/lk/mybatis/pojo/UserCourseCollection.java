package com.lk.mybatis.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("收藏pojo")
public class UserCourseCollection implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户id")
    @Column(name = "user_id")
    private Integer userId;
    @ApiModelProperty("课程id")
    @Column(name = "course_id")
    private Integer courseId;
    @ApiModelProperty("收藏时间")
    @Column(name = "collect_time")
    private Date collectTime;
    @ApiModelProperty("课程时间")
    @Column(name = "course_time")
    private Date courseTime;
    @ApiModelProperty("排序时间")
    @Column(name = "order_time")
    private Date orderTime;
}

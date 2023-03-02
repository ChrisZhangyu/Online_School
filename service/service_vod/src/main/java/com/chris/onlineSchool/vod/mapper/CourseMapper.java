package com.chris.onlineSchool.vod.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chris.onlineSchool.model.vod.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.onlineSchool.viewobject.vod.CoursePublishVo;
import com.chris.onlineSchool.viewobject.vod.CourseQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {
    /** 自定义分页查询,多表联查,一次就查出教师姓名和课程名字不用再循环查
     * @param page
     * @param courseQueryVo
     * @return
     */
    IPage<Course> selectPage(IPage<Course> page, @Param("courseQueryVo")CourseQueryVo courseQueryVo);

    /** 略
     * @param id
     * @return
     */
    CoursePublishVo getPublishById(@Param("id")Long id);

}

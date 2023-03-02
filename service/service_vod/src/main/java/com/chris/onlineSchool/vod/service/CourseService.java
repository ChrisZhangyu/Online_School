package com.chris.onlineSchool.vod.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chris.onlineSchool.model.vod.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.CourseFormVo;
import com.chris.onlineSchool.viewobject.vod.CoursePublishVo;
import com.chris.onlineSchool.viewobject.vod.CourseQueryVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
public interface CourseService extends IService<Course> {
    /**
     * 分页查询course表，并将其中的teacherId，parentId转换为教师名字和课程名字
     * @param page 要查询的页
     * @param limit 每页多少条数据
     * @param courseQueryVo 查询条件
     * @return
     */
    Result getCourseList(Long page, Long limit, CourseQueryVo courseQueryVo);

    /** 添加课程信息，包括基本信息和描述信息
     * @param courseFormVo 前端提交的表单
     * @return
     */
    Long addCourse(CourseFormVo courseFormVo);

    /** 修改课程信息和课程描述信息
     * @param courseFormVo
     * @return
     */
    void updateCourse(CourseFormVo courseFormVo);

    /** 查询课程信息和课程描述信息并包装到一起
     * @param id
     * @return
     */
    CourseFormVo getCourseInfoById(Long id);

    /** 查询当前课程的所有信息用于在发布页面显示
     * @param id
     * @return
     */
    CoursePublishVo getPublishById(Long id);

    /**
     * 修改课程的发布状态
     * @param id
     */
    void publishCourse(Long id);

    /**
     * 删除课程
     * @param id
     */
    void deleteCourse(Long id);
}

package com.chris.onlineSchool.vod.controller;


import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.onlineSchool.model.vod.Course;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.CourseFormVo;
import com.chris.onlineSchool.viewobject.vod.CourseQueryVo;
import com.chris.onlineSchool.vod.mapper.CourseMapper;
import com.chris.onlineSchool.vod.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.ResultType;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Api("")
@RestController
@RequestMapping("/admin/vod/course")
//@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;


    @ApiOperation("分页查询课程列表")
    @GetMapping("courseList/{page}/{limit}")
    public Result coursePageList(@PathVariable Long page,
                                 @PathVariable Long limit,
                                 CourseQueryVo courseQueryVo) {
        
        return Result.success(courseService.getCourseList(page, limit, courseQueryVo));

    }

    @ApiOperation("添加课程")
    @PostMapping("add")
    public Result addCourse(@RequestBody CourseFormVo courseFormVo) {
        return Result.success(courseService.addCourse(courseFormVo));

    }


    @ApiOperation("根据id查询课程课程")
    @GetMapping("get/{id}")
    public Result getCourseById(@PathVariable Long id) {
        return Result.success(courseService.getCourseInfoById(id));
    }

    @ApiOperation("根据id查询即将发布的课程信息")
    @GetMapping("getPublish/{id}")
    public Result getPublishById(@PathVariable Long id) {
        return Result.success(courseService.getPublishById(id));
    }

    @ApiOperation("修改课程")
    @PutMapping("update")
    public Result updateCourse(@RequestBody CourseFormVo courseFormVo) {
        courseService.updateCourse(courseFormVo);
        return Result.success(courseFormVo.getId());

    }

    //课程最终发布
    @ApiOperation("课程最终发布")
    @PutMapping("publishCourse/{id}")
    public Result publishCourse(@PathVariable Long id) {
        courseService.publishCourse(id);
        return Result.success();
    }


    @ApiOperation("删除课程")
    @DeleteMapping ("remove/{id}")
    public Result removeCourseById(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return Result.success();
    }
}


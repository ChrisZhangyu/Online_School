package com.chris.onlineSchool.vod.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.onlineSchool.model.vod.Course;
import com.chris.onlineSchool.model.vod.CourseDescription;
import com.chris.onlineSchool.model.vod.Video;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.CourseFormVo;
import com.chris.onlineSchool.viewobject.vod.CoursePublishVo;
import com.chris.onlineSchool.viewobject.vod.CourseQueryVo;
import com.chris.onlineSchool.vod.mapper.CourseMapper;
import com.chris.onlineSchool.vod.service.ChapterService;
import com.chris.onlineSchool.vod.service.CourseDescriptionService;
import com.chris.onlineSchool.vod.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    CourseDescriptionService descriptionService;

    @Autowired
    VideoService videoService;

    @Autowired
    ChapterService chapterService;

    @Override
    public Result getCourseList(Long page, Long limit, CourseQueryVo courseQueryVo) {
        Page<Course> pageParam = new Page<>(page, limit);
        IPage<Course> pageInfo = courseMapper.selectPage(pageParam, courseQueryVo);
        return Result.success(pageInfo);

//        if(courseQueryVo == null){
//            IPage<Course> pageInfo = courseMapper.selectPage(pageParam, courseQueryVo);
//            return Result.success(pageInfo);
//        }else {
//            QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
//
//            Long teacherId = courseQueryVo.getTeacherId();
//            String title = courseQueryVo.getTitle();
//            Long subjectId = courseQueryVo.getSubjectId();
//            Long subjectParentId = courseQueryVo.getSubjectParentId();
//
//            if (!StringUtils.isEmpty(teacherId)){
//                queryWrapper.and(condition -> {condition.eq("teacher_id", teacherId);});
//            }
//            if (!StringUtils.isEmpty(title)){
//                queryWrapper.like("title", title);
//            }
//            if (!StringUtils.isEmpty(subjectId)){
//                queryWrapper.eq("subject_id", subjectId);
//            }
//            if (!StringUtils.isEmpty(subjectParentId)){
//                queryWrapper.eq("subjectParent_id", subjectParentId);
//            }
//            IPage<Course> pageInfo = courseMapper.selectPage(pageParam, queryWrapper);
//            return Result.success(pageInfo);
//
//        }
    }

    @Override
    public Long addCourse(CourseFormVo courseFormVo) {
        //添加课程基本信息，操作course表
        Course course = new Course();
        if(courseFormVo.getCover() == null){
            courseFormVo.setCover("");
        }

        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        //添加课程描述信息，操作course_description
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());
        //设置课程id
        courseDescription.setId(course.getId());
        courseDescription.setCourseId(course.getId());
        descriptionService.save(courseDescription);

        return course.getId();

    }

    @Override
    public void updateCourse(CourseFormVo courseFormVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo,course);
        baseMapper.updateById(course);


        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());

        courseDescription.setId(course.getId());
        descriptionService.updateById(courseDescription);


    }

    @Override
    public CourseFormVo getCourseInfoById(Long id) {
//        先查课程基本信息
        CourseFormVo courseFormVo = new CourseFormVo();
        Course course = courseMapper.selectById(id);
        if (course == null){
            return  null;
        }
        BeanUtils.copyProperties(course, courseFormVo);
//        再查描述信息
        CourseDescription courseDescription = descriptionService.getById(id);
        if (courseDescription != null){
            courseFormVo.setDescription(courseDescription.getDescription());
        }
        return courseFormVo;
    }

    @Override
    public CoursePublishVo getPublishById(Long id) {
        return courseMapper.getPublishById(id);
    }

    @Override
    public void publishCourse(Long id) {
        Course course = baseMapper.selectById(id);
        course.setStatus(1);
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }

    @Override
    public void deleteCourse(Long id) {
//    video表和chapter表中的id和courseId不对应，因此需要单独实现
        videoService.removeVideoByCourseId(id);
        chapterService.removeChapterByCourseId(id);

        descriptionService.removeById(id);
        baseMapper.deleteById(id);
    }

}

package com.chris.onlineSchool.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chris.onlineSchool.model.vod.Chapter;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.ChapterVo;
import com.chris.onlineSchool.vod.mapper.ChapterMapper;
import com.chris.onlineSchool.vod.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    ChapterMapper chapterMapper;
    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        return chapterMapper.getTreeList(courseId);
    }

    @Override
    public void removeChapterByCourseId(Long id) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        chapterMapper.delete(wrapper);
    }
}

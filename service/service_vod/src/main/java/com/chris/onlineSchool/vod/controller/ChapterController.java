package com.chris.onlineSchool.vod.controller;


import com.chris.onlineSchool.model.vod.Chapter;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.ChapterVo;
import com.chris.onlineSchool.vod.service.ChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Api("大纲接口")
@RestController
@RequestMapping("/admin/vod/chapter")
//@CrossOrigin
public class ChapterController {
    @Autowired
    private ChapterService chapterService;


    /**
     * 1 大纲列表（章节和小节列表）
     */
    @ApiOperation("大纲列表")
    @GetMapping("getNestedTreeList/{courseId}")
    public Result getTreeList(@PathVariable Long courseId) {
        List<ChapterVo> list = chapterService.getTreeList(courseId);
        return Result.success(list);
    }

    /**
     * 2 添加章节
     */
    @PostMapping("save")
    public Result saveChapter(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return Result.success();
    }

    /**
     * 3 修改-根据id查询
     */
    @GetMapping("get/{id}")
    public Result getChapter(@PathVariable Long id) {
        Chapter chapter = chapterService.getById(id);
        return Result.success(chapter);
    }

    /**
     * 4 修改-最终实现
     */
    @PostMapping("update")
    public Result updateChapter(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return Result.success();
    }

    /**
     * 5 删除章节
     */
    @DeleteMapping("remove/{id}")
    public Result removeChapter(@PathVariable Long id) {
        chapterService.removeById(id);
        return Result.success();
    }
}


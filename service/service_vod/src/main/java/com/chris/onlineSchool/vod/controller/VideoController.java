package com.chris.onlineSchool.vod.controller;


import com.chris.onlineSchool.model.vod.Chapter;
import com.chris.onlineSchool.model.vod.Video;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.ChapterVo;
import com.chris.onlineSchool.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Api("小节视频接口")
@RestController
@RequestMapping("/admin/vod/video")
//@CrossOrigin
public class VideoController {

    @Autowired
    VideoService videoService;


    @PostMapping("save")
    public Result saveChapter(@RequestBody Video video) {
        videoService.save(video);
        return Result.success();
    }

    @GetMapping("get/{id}")
    public Result getChapter(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return Result.success(video);
    }

    @PostMapping("update")
    public Result updateChapter(@RequestBody Video video) {
        videoService.updateById(video);
        return Result.success();
    }

    @DeleteMapping("remove/{id}")
    public Result removeChapter(@PathVariable Long id) {
        videoService.removeById(id);
        return Result.success();
    }

}


package com.chris.onlineSchool.vod.controller;


import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author chris
 * @since 2022-12-04
 */
@Api("课程统计接口")
@RestController
@RequestMapping("/admin/vod/videoVisitor")
//@CrossOrigin
public class VideoVisitorController {
    @Autowired
    private VideoVisitorService videoVisitorService;

    @GetMapping("getCount/{courseId}/{startDate}/{endDate}")
    private Result getCount(@PathVariable Long courseId,
                            @PathVariable String startDate,
                            @PathVariable String endDate){

        Map<String, Object> res = videoVisitorService.getCount(courseId, startDate, endDate);
        return Result.success(res);
    }

}


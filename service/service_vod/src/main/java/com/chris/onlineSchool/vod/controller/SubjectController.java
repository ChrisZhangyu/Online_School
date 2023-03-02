package com.chris.onlineSchool.vod.controller;

import com.chris.onlineSchool.model.vod.Subject;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author chris
 * @date 2022/11/15
 */
@Api(tags = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/subject")
//@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("课程分类列表")
    @GetMapping("getSubjectsAndChild/{id}")
    public Result getSubjectsAndChild(@PathVariable Long id) {
        List<Subject> subjects = subjectService.selectSubjectList(id);
        return Result.success(subjects);
    }


    @ApiOperation("导出excel文件")
    @GetMapping("exportData")
    public void exportSubject(HttpServletResponse response){
        subjectService.exportData(response);
    }

    @ApiOperation("导入excel文件")
    @PostMapping("importData")
    public Result importSubject(MultipartFile file){
        subjectService.importData(file);
        System.out.println("*********************上传文件");
        return Result.success();
    }
}

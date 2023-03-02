package com.chris.onlineSchool.vod.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.onlineSchool.model.vod.Teacher;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.vod.TeacherQueryVO;
import com.chris.onlineSchool.vod.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

/**
 * @author chris
 * @date 2022/11/9
 */
@Api(tags = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
//@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
//    public List<Teacher> getAll(){
//        return teacherService.list();
//    }

    public Result<List<Teacher>> getAll(){
        return Result.success(teacherService.list()).message("查询数据成功");
    }

    @ApiOperation("根据id查询老师")
    @GetMapping("get/{id}")
//    public Teacher getTeacherById(@PathVariable Long id){
//        return teacherService.getById(id);
//    }

    public Result<Teacher> getTeacherById(@PathVariable Long id){
        return Result.success(teacherService.getById(id)).message("查询数据成功");
    }

    @ApiOperation("删除讲师")
    @DeleteMapping("remove/{id}")
    public Result deleteById(@PathVariable Long id){
        return teacherService.removeById(id)?Result.success():Result.fail();

    }

    @ApiOperation("添加讲师")
    @PutMapping("save")
    public Result saveTeacher(@RequestBody Teacher teacher){
        return teacherService.save(teacher)?Result.success():Result.fail();
    }

    /**
     * 修改分为两步，先查询，再添加
     * @return
     */
    @ApiOperation("修改老师信息")
    @PostMapping("update")
    public Result<Teacher> updateTeacher(@RequestBody Teacher teacher){
        return teacherService.updateById(teacher)?Result.success():Result.fail();
    }

    @ApiOperation("条件分页查询")
    @PostMapping("findQueryPage/{current}/{limit}")
    public Result findPage(@PathVariable("current") long current,
                           @PathVariable("limit") long limit,
                           @RequestBody(required = false) TeacherQueryVO tvo){


//          设置分页查询的当前页及总数
        Page<Teacher> pageParam = new Page<>(current, limit);
        if (tvo == null){
//            调用mbp的方法
            IPage<Teacher> iPage = teacherService.page(pageParam, null);
            return Result.success(iPage);
        }else {
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
//            判断非空，注意，这里要判断空字符串而不是空对象，即要判断""而不是null
            if (!StringUtils.isEmpty(tvo.getName())){
                wrapper.like("name", tvo.getName());
            }
            if (!StringUtils.isEmpty(tvo.getLevel())){
                wrapper.eq("level", tvo.getLevel());
            }
//            加入时间必须在用户搜索的时间范围内
            if (!StringUtils.isEmpty(tvo.getJoinDateBegin())){
                wrapper.ge("join_date", tvo.getJoinDateBegin());
            }
            if (!StringUtils.isEmpty(tvo.getJoinDateEnd())){
                wrapper.le("join_date", tvo.getJoinDateEnd());
            }
            IPage<Teacher> iPage = teacherService.page(pageParam, wrapper);
            return Result.success(iPage);

        }

    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchDeleteTeacher")
    public Result batchDelete(@RequestBody  List<Long> idList){
        System.out.println("*****************************************************");
        return teacherService.removeByIds(idList)?Result.success():Result.fail();
    }

}

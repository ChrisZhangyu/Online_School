package com.chris.onlineSchool.vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.model.vod.Subject;
import com.chris.onlineSchool.viewobject.vod.SubjectEeVo;
import com.chris.onlineSchool.vod.Listener.SubjectListener;
import com.chris.onlineSchool.vod.mapper.SubjectMapper;
import com.chris.onlineSchool.vod.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chris
 * @date 2022/11/15
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private SubjectListener sl;

    /**
     * 需要进行处理，查询出的数据要把hasChildren更改一下
     *
     */
    @Override
    public List<Subject> selectSubjectList(Long parentId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        List<Subject> subjectList = baseMapper.selectList(wrapper);
//        判断查询的顶层课程有没有子课程，而后给hasChildren属性赋值
        for(Subject subject: subjectList){
            Long id = subject.getId();
            subject.setHasChildren(hasChild(id));
        }
        return subjectList;
    }



    @Override
    public void exportData(HttpServletResponse response) {
        try {
//            设置下载文件的mime类型
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("课程分类", "UTF-8");

            response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");

//            查询课程分类表中的所有数据
            List<Subject> subjectList = baseMapper.selectList(null);
            List<SubjectEeVo> subjectEeVos = new ArrayList<>();

            for (Subject s: subjectList) {
                SubjectEeVo subjectEeVo = new SubjectEeVo();
//                spring提供的工具类，将A对象的属性赋给B对象，只对两个对象相同的属性赋值，如果A中的属性B中没有，那么就跳过这个属性
                BeanUtils.copyProperties(s, subjectEeVo);
                subjectEeVos.add(subjectEeVo);
            }
//            使用EasyExcel写入
            EasyExcel.write(response.getOutputStream(), SubjectEeVo.class)
                    .sheet("课程分类表")
                    .doWrite(subjectEeVos);
        }catch (Exception e) {

        }
    }

    @Override
    public void importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), SubjectEeVo.class, sl)
                    .sheet()
                    .doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean hasChild(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;

    }
}

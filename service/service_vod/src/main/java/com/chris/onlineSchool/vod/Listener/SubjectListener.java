package com.chris.onlineSchool.vod.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.chris.onlineSchool.model.vod.Subject;
import com.chris.onlineSchool.viewobject.vod.SubjectEeVo;
import com.chris.onlineSchool.vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author chris
 * @date 2022/11/16
 */

@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo> {

    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * EasyExcel一行一行的读数据
     * @param subjectEeVo 存放每行数据
     * @param analysisContext 获取表格的上下文信息
     */
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectEeVo, subject);
//        写入数据库
        subjectMapper.insert(subject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

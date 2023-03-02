package com.chris.onlineSchool.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author chris
 * @date 2022/11/15
 */

public interface SubjectService extends IService<Subject> {
    /**查询父id为特定值的所有课程，例如id=0时表示查询所有顶层课程分类
     * @param id id表示当前课程父课程的id号
     * @return
     */
    List<Subject> selectSubjectList(Long id);

    /**导出功能的实现
     * 将查询出的数据保存起来
     * @param response
     */
    void exportData(HttpServletResponse response);

    /** 读取excel内容并保存到数据库中，而后返回给前端
     *
     * @param file
     */
    void importData(MultipartFile file);
}

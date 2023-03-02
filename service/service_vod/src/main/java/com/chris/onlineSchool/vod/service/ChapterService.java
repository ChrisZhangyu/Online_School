package com.chris.onlineSchool.vod.service;

import com.chris.onlineSchool.model.vod.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.viewobject.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
public interface ChapterService extends IService<Chapter> {

    /** 获取当前章节以及其小节信息
     * @param courseId
     * @return
     */
    List<ChapterVo> getTreeList(Long courseId);

    /** 根据课程id删除所有章节
     * @param id
     */
    void removeChapterByCourseId(Long id);
}

package com.chris.onlineSchool.vod.service;

import com.chris.onlineSchool.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
public interface VideoService extends IService<Video> {

    /** 根据课程id删除所有小节
     * @param id
     */
    void  removeVideoByCourseId(Long id);

}

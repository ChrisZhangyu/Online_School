package com.chris.onlineSchool.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.model.vod.VideoVisitor;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 服务类
 * </p>
 *
 * @author chris
 * @since 2022-12-04
 */
public interface VideoVisitorService extends IService<VideoVisitor> {

    public Map<String, Object> getCount(Long courseId, String startDate, String endDate);
}

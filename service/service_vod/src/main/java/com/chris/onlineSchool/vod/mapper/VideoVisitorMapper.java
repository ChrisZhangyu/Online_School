package com.chris.onlineSchool.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.onlineSchool.model.vod.VideoVisitor;
import com.chris.onlineSchool.viewobject.vod.VideoVisitorCountVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author chris
 * @since 2022-12-04
 */
@Repository
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    /** 查找范围内的课程访问统计
     * @param courseId
     * @param startDate
     * @param endDate
     * @return
     */
    List<VideoVisitorCountVo> getCount(@Param("courseId") Long courseId,
                                       @Param("startDate")String startDate,
                                       @Param("endDate")String endDate);

}

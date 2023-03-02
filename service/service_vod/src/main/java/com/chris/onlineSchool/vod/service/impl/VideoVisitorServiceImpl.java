package com.chris.onlineSchool.vod.service.impl;

import com.chris.onlineSchool.model.vod.VideoVisitor;
import com.chris.onlineSchool.viewobject.vod.VideoVisitorCountVo;
import com.chris.onlineSchool.viewobject.vod.VideoVisitorVo;
import com.chris.onlineSchool.vod.mapper.VideoVisitorMapper;
import com.chris.onlineSchool.vod.service.VideoVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 视频来访者记录表 服务实现类
 * </p>
 *
 * @author chris
 * @since 2022-12-04
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    @Autowired
    private VideoVisitorMapper videoVisitorMapper;

    @Override
    public Map<String, Object> getCount(Long courseId, String startDate, String endDate) {
        List<VideoVisitorCountVo> videoCountList = videoVisitorMapper.getCount(courseId, startDate, endDate);
        Map<String, Object> videoCountMap = new HashMap<>();
        //创建两个list集合，一个代表所有日期，一个代表日期对应数量
        //封装数据  代表所有日期
//        流处理
        List<String> dateList = videoCountList.stream().map(VideoVisitorCountVo::getJoinTime).collect(Collectors.toList());
        List<Integer> countList = videoCountList.stream().map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());

//        封装
        videoCountMap.put("xData", dateList);
        videoCountMap.put("yData", countList);

        return videoCountMap;
    }
}

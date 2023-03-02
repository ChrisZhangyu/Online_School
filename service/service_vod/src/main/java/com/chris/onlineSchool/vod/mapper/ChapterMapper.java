package com.chris.onlineSchool.vod.mapper;

import com.chris.onlineSchool.model.vod.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.onlineSchool.viewobject.vod.ChapterVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author chris
 * @since 2022-11-17
 */
@Repository
public interface ChapterMapper extends BaseMapper<Chapter> {
    /** 查询章节的树形结构
     * @param courseId 章节id
     * @return
     */
    List<ChapterVo> getTreeList(@Param("courseId") Long courseId);
}

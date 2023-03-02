package com.chris.onlineSchool.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.onlineSchool.model.vod.Teacher;
import org.springframework.stereotype.Repository;

/**
 * @author chris
 * @date 2022/11/9
 *
 * mb-plus的写法，集成BaseMapper，其中已经内置一些常用的增删改查
 */

@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
}

package com.chris.onlineSchool.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.model.vod.Teacher;
import com.chris.onlineSchool.vod.mapper.TeacherMapper;
import com.chris.onlineSchool.vod.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @author chris
 * @date 2022/11/9
 *
 * mb-plus的写法，将Service与mapper直接绑定，省略了在Service中注入mapper的语句
 */

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}

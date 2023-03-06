package com.chris.onlineSchool.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.onlineSchool.model.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chris
 * @date 2023/3/5 21:56
 */
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {
}

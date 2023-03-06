package com.chris.onlineSchool.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.model.user.UserInfo;
import com.chris.onlineSchool.user.mapper.UserMapper;
import com.chris.onlineSchool.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chris
 * @date 2023/3/5 21:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean verify(String name, String password) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name).eq("password", password);

        return userMapper.selectCount(queryWrapper) == 1;
    }
}

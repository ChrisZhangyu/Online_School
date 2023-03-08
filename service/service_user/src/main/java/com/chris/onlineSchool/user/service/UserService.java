package com.chris.onlineSchool.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.model.user.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author Chris
 * @date 2023/3/5 21:55
 */
public interface UserService extends IService<UserInfo> {
    public String verify(String name, String password);
}

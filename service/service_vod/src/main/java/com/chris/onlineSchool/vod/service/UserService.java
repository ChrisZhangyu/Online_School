package com.chris.onlineSchool.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.model.user.UserInfo;

/**
 * @author Chris
 * @date 2023/3/5 21:55
 */
public interface UserService extends IService<UserInfo> {
    public Boolean verify(String name, String password);
}

package com.chris.onlineSchool.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.model.user.UserInfo;
import com.chris.onlineSchool.user.mapper.UserMapper;
import com.chris.onlineSchool.user.service.UserService;
import com.chris.onlineSchool.utils.JwtUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Chris
 * @date 2023/3/5 21:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String verify(String name, String password) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name).eq("password", password);
        UserInfo userInfo = userMapper.selectOne(queryWrapper);

        if (userInfo != null){
            //        利用反射将user对象转换成map
            Field[] fields = userInfo.getClass().getDeclaredFields();
            Map<String, String> userMap = new HashedMap<>();
            for(Field item : fields){
                item.setAccessible(true);
                try {
                    userMap.put(item.getName(), (String) item.get(userInfo));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return JwtUtils.getToken(name, userMap);
        }else {
            return "";
        }
    }
}

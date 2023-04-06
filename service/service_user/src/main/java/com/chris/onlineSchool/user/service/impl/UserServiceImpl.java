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


    public  static int strStr(String haystack, String needle) {
        int length = haystack.length();
        int [] next = new int [length];

        getNext(next, needle);
        for(int item : next){
            System.out.print(item + " ");
        }
        for(int i = 0, j = 0; i < length; ){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
            }else if(j > 0){
                j = next[j - 1];
            }
            if(j == needle.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

//    public static int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//        int[] next = new int[needle.length()];
//        getNext(next, needle);
//
//        int j = 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
//                j = next[j - 1];
//            if (needle.charAt(j) == haystack.charAt(i))
//                j++;
//            if (j == needle.length())
//                return i - needle.length() + 1;
//        }
//        return -1;
//
//    }

    private static void getNext(int[] next, String s) {
        for(int i = 1, j = 0; i < s.length() - 1;i++){
            if( s.charAt(i) == s.charAt(j)){
                j++;
                next[i] = j;

            }else if(j > 0){
                j = next[j - 1];

            }
        }
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String needle = "issip";
//        int [] next = new int[s.length()];
        strStr(s, needle);
    }


}

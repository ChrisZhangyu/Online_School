package com.chris.onlineSchool.vod.controller;

import com.chris.onlineSchool.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chris
 * @date 2022/11/13
 */

@RestController
@RequestMapping("/admin/vod/user")
//@CrossOrigin
public class UserLoginController {


    @RequestMapping("login")
    /**
     * @return:
     * {"code":20000,"data":{"token":"admin-token"}}
     */
    public Result login(){
        Map<String, String> response = new HashMap<String, String>();
        response.put("token", "admin-toke");
        return Result.success(response);

    }


    @RequestMapping("info")
    /**
     * @return:
     * {"code":20000,
     * "data":
     * {"roles":["admin"],
     * "introduction":"I am a super administrator",
     * "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
     * "name":"Super Admin"}}
     */
    public Result info(){
        Map<String, String> response = new HashMap<String, String>();
        response.put("roles", "admin");
        response.put("introduction", "I am a super administrator");
        response.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        response.put("name", "Chris");
        return Result.success(response);

    }
}

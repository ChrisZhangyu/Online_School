package com.chris.onlineSchool.vod.controller;

import com.chris.onlineSchool.model.user.UserInfo;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.vod.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author chris
 * @date 2022/11/13
 */

@RestController
@RequestMapping("/admin/vod/user")
//@CrossOrigin
public class UserLoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    /**
     * @return:
     * {"code":20000,"data":{"token":"admin-token"}}
     */
    public Result login(@RequestBody UserInfo loginForm){
        Map<String, String> response = new HashMap<String, String>();
        long time = 1000*60*60;
        String userName = loginForm.getName();
        String id = UUID.randomUUID().toString();
        String signature = userName + id;
        if(userService.verify(userName, loginForm.getPassword())){
            JwtBuilder jwtBuilder = Jwts.builder();
            String token = jwtBuilder
                    .setHeaderParam("typ", "JWT")
                    .setHeaderParam("alg", "HS256")
                    .setExpiration(new Date(System.currentTimeMillis() + time))
                    .claim("username", userName)
                    .claim("role", "user")
                    .setId(id)
                    .signWith(SignatureAlgorithm.HS256, signature)
                    .compact();
            response.put("token", token);
            return Result.success(response);
        }else {
            return Result.fail(response);

        }
    }

    @RequestMapping("register")
    public Result register(@RequestBody UserInfo registerForm){
        return userService.save(registerForm)?Result.success():Result.fail();
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

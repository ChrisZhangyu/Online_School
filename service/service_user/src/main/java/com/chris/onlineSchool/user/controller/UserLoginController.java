package com.chris.onlineSchool.user.controller;

import com.chris.onlineSchool.model.user.UserInfo;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.user.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author chris
 * @date 2022/11/13
 */
@Api(tags = "用户登录测试")
@RestController
@RequestMapping("/admin/user")
public class UserLoginController {
    @Autowired
    private UserService userService;
    @ApiOperation("登录")
    @PostMapping ("login")
    /**
     * @return:
     * {"code":20000,"data":{"token":"admin-token"}}
     */
    public Result login(@RequestBody UserInfo loginForm){
        Map<String, String> response = new HashMap<String, String>();

        long time = 1000*60*60;
        String userName = loginForm.getName();
        System.out.println(userName);
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
    @ApiOperation("注册")
    @PostMapping("register")
    public Result register(@RequestBody UserInfo registerForm){
        return userService.save(registerForm)?Result.success():Result.fail();
    }


    @GetMapping("info")
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

package com.chris.onlineSchool.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

public class JwtUtils {
    public static String getToken(String userName, Map<String, String> userInfo){
        long time = 1000*60*60;
        String id = UUID.randomUUID().toString();
        String signature = userName + id;
        JwtBuilder jwtBuilder = Jwts.builder();
        JwtBuilder tempBuilder = jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .claim("role", "user")
                .setId(id)
                .signWith(SignatureAlgorithm.HS256, signature);

        for(Map.Entry<String, String> item : userInfo.entrySet()){
            tempBuilder = tempBuilder.claim(item.getKey(), item.getValue());
        }
        return tempBuilder.compact();
    }
}

package com.chris.onlineSchool.vod;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.CharacterIterator;


/**
 * @author chris
 * @date 2022/11/9
 */

@SpringBootApplication
@MapperScan("com.chris.onlineSchool.vod.mapper")
@EnableDiscoveryClient
@EnableSwagger2
public class ServiceVodApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceVodApplication.class ,args);
    }
}

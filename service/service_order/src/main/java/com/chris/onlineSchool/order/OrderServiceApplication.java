package com.chris.onlineSchool.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author chris
 * @date 2022/12/5
 */
@SpringBootApplication()
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.chris.onlineSchool.order.mapper")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}

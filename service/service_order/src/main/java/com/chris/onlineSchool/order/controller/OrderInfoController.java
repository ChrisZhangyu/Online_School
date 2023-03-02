package com.chris.onlineSchool.order.controller;

import com.chris.onlineSchool.order.service.OrderInfoService;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.order.OrderInfoQueryVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chris
 * @date 2022/12/5
 */

@Api("订单管理模块")
@RestController
@RequestMapping("/admin/order/orderInfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("getPage/{limit}/{pageNum}")
    public Result getPage(@PathVariable Long limit,
                          @PathVariable Long pageNum,
                          OrderInfoQueryVo orderInfoQueryVo){

        return Result.success(orderInfoService.getPage(limit, pageNum, orderInfoQueryVo));

    }
}

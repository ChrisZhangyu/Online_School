package com.chris.onlineSchool.activity.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.onlineSchool.activity.service.CouponInfoService;
import com.chris.onlineSchool.model.activity.CouponInfo;
import com.chris.onlineSchool.result.Result;
import com.chris.onlineSchool.viewobject.order.OrderInfoQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author chris
 * @since 2022-12-06
 */
@Api("营销管理模块")
@RestController
@RequestMapping("/admin/activity/couponInfo")
public class CouponInfoController {

    @Autowired
    private CouponInfoService couponInfoService;

    @ApiOperation("获取优惠券")
    @GetMapping("get/{id}")
    public Result getCoupon(@PathVariable Long id){
        return Result.success(couponInfoService.getById(id));
    }


    @ApiOperation("修改优惠券")
    @GetMapping("put")
    public Result putCoupon(@RequestBody CouponInfo couponInfo){
        return Result.success(couponInfoService.updateById(couponInfo));
    }

    @ApiOperation("删除优惠券")
    @GetMapping("remove/{id}")
    public Result removeCoupon(@PathVariable Long id){
        return Result.success(couponInfoService.removeById(id));
    }

    @ApiOperation("添加优惠券")
    @GetMapping("post")
    public Result postCoupon(@RequestBody CouponInfo couponInfo){
        return Result.success(couponInfoService.save(couponInfo));
    }

    @ApiOperation("批量删除优惠券")
    @GetMapping("removeBatch")
    public Result removeBatchCoupon(@RequestBody List<Long> idList){
        return Result.success(couponInfoService.removeByIds(idList));
    }

    @ApiOperation("分页查询优惠券")
    @GetMapping("getPage/{limit}/{currPage}")
    public Result getPage(@PathVariable Long limit,
                          @PathVariable Long currPage){
        Page<CouponInfo> pageParam  = new Page<>(currPage, limit);
        return Result.success(couponInfoService.page(pageParam));
    }

    @ApiOperation("分页查询优惠券")
    @GetMapping("getPage/{limit}/{pageNum}")
    public Result getPage(@PathVariable Long limit,
                          @PathVariable Long pageNum,
                          OrderInfoQueryVo orderInfoQueryVo){

        return Result.success(couponInfoService.getPage(limit, pageNum, orderInfoQueryVo));

    }
}


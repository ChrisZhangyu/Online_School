package com.chris.onlineSchool.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.model.activity.CouponInfo;
import com.chris.onlineSchool.model.order.OrderInfo;
import com.chris.onlineSchool.viewobject.order.OrderInfoQueryVo;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author chris
 * @since 2022-12-06
 */
public interface CouponInfoService extends IService<CouponInfo> {
    /** 查看已使用的优惠券，分页查询带条件
     * @param limit
     * @param pageNum
     * @param orderInfoQueryVo
     * @return
     */
    public IPage<CouponInfo> getPage(Long limit, Long pageNum, OrderInfoQueryVo orderInfoQueryVo);


}

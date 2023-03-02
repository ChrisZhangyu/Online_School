package com.chris.onlineSchool.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.onlineSchool.activity.mapper.CouponInfoMapper;
import com.chris.onlineSchool.activity.service.CouponInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.model.activity.CouponInfo;
import com.chris.onlineSchool.model.order.OrderInfo;
import com.chris.onlineSchool.viewobject.order.OrderInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 *
 * @author chris
 * @since 2022-12-06
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
    @Autowired
    private CouponInfoMapper couponInfoMapper;

    @Override
    public IPage<CouponInfo> getPage(Long limit, Long pageNum, OrderInfoQueryVo orderInfoQueryVo) {

        Page<CouponInfo> pageParam = new Page<>(pageNum, limit);
        QueryWrapper<CouponInfo> queryWrapper = new QueryWrapper();


        return null;
    }
}

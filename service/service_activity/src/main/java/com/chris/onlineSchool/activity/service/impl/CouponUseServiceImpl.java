package com.chris.onlineSchool.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.onlineSchool.activity.mapper.CouponInfoMapper;
import com.chris.onlineSchool.activity.mapper.CouponUseMapper;
import com.chris.onlineSchool.activity.service.CouponUseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chris.onlineSchool.model.activity.CouponUse;
import com.chris.onlineSchool.model.order.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券领用表 服务实现类
 * </p>
 *
 * @author chris
 * @since 2022-12-06
 */
@Service
public class CouponUseServiceImpl extends ServiceImpl<CouponUseMapper, CouponUse> implements CouponUseService {

}

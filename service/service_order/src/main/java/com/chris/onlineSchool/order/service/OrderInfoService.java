package com.chris.onlineSchool.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.onlineSchool.model.order.OrderInfo;
import com.chris.onlineSchool.viewobject.order.OrderInfoQueryVo;
import org.springframework.stereotype.Service;

/**
 * @author chris
 * @date 2022/12/5
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 条件查询带分页
     *
     * @param limit
     * @param pageNum
     * @param orderInfoQueryVo
     * @return
     */
    public IPage<OrderInfo> getPage(Long limit, Long pageNum, OrderInfoQueryVo orderInfoQueryVo);
}

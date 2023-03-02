package com.chris.onlineSchool.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.onlineSchool.model.order.OrderInfo;

/**
 * @author chris
 * @date 2022/12/5
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    /** 利用sql实现条件分页带查询
     * @param pageParam
     * @param orderInfoQueryVo
     * @return
     */
//    IPage<OrderInfo> getPage(IPage<OrderInfo> pageParam, @Param("OrderQueryVo") OrderInfoQueryVo orderInfoQueryVo);
}

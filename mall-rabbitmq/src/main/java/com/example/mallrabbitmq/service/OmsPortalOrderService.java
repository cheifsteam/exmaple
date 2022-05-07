package com.example.mallrabbitmq.service;

import com.example.mallrabbitmq.common.CommonResult;
import com.example.mallrabbitmq.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface OmsPortalOrderService {
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    @Transactional
    void cancelOrder(Long orderId);
}

package com.example.mallrabbitmq.service.impl;

import com.example.mallrabbitmq.common.CommonResult;
import com.example.mallrabbitmq.component.CancelOrderSender;
import com.example.mallrabbitmq.dto.OrderParam;
import com.example.mallrabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
   private  static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
   @Autowired
   private CancelOrderSender cancelOrderSender;
    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
      //todo 执行一系列下单操作，具体参考mall项目
        LOGGER.info("process generateOrder");
        sendDelayMessageCancelOrder(11l);
        return CommonResult.success(null,"下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行取消订单操作
        LOGGER.info("process cancelOrder orderId{}",orderId);
    }
    private void sendDelayMessageCancelOrder(Long orderId){
        long delayTimes =30 *1000;
        cancelOrderSender.sendMessage(orderId,delayTimes);
    }
}

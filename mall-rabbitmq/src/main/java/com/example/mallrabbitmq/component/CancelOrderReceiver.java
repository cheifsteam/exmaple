package com.example.mallrabbitmq.component;

import com.example.mallrabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Component
//@RabbitListener(queues ="mall.order.cancel") //监听死信队列
@RabbitListener(queues = "mall.order.cancel.plugin")
public class CancelOrderReceiver {
    private  static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    private void handle(Long orderId){
        LOGGER.info("receive delay message{}",orderId);
        portalOrderService.cancelOrder(orderId);
    }
}

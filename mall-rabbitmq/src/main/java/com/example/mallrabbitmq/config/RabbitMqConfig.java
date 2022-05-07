package com.example.mallrabbitmq.config;


import com.example.mallrabbitmq.dto.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息队列配置
 * Created by macro on 2018/9/14.
 */
@Configuration
public class RabbitMqConfig {

//    /**
//     * 订单消息实际消费队列所绑定的交换机(死信交换机）
//     */
//    @Bean
//    DirectExchange orderDirect() {
//        return (DirectExchange) ExchangeBuilder
//                .directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
//                .durable(true)
//                .build();
//    }
//
//    /**
//     * 订单延迟队列队列所绑定的交换机
//     */
//    @Bean
//    DirectExchange orderTtlDirect() {
//        return (DirectExchange) ExchangeBuilder
//                .directExchange(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange())
//                .durable(true)
//                .build();
//    }
//
//    /**
//     * 订单实际消费队列(死信队列）
//     */
//    @Bean
//    public Queue orderQueue() {
//        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getName());
//    }
//
//    /**
//     * 订单延迟队列
//     */
////   x-message-ttl：延迟时间
////    x-dead-letter-exchange：绑定的死信交换机
////    x-dead-letter-routing-key： 绑定的路由，一般是对应死信队列名称。
//    @Bean
//    public Queue orderTtlQueue() {
//        return QueueBuilder
//                .durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getName())
//                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.getExchange())//到期后转发的交换机
//                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())//到期后转发的路由键
//                .build();
//    }
//
//
//    /**
//     * 将订单队列绑定到交换机
//     */
//    @Bean
//    Binding orderBinding(DirectExchange orderDirect,Queue orderQueue){
//        return BindingBuilder
//                .bind(orderQueue)
//                .to(orderDirect)
//                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
//    }
//
//    /**
//     * 将订单延迟队列绑定到交换机
//     */
//    @Bean
//    Binding orderTtlBinding(DirectExchange orderTtlDirect,Queue orderTtlQueue){
//        return BindingBuilder
//                .bind(orderTtlQueue)
//                .to(orderTtlDirect)
//                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
//    }

//-----------------------------------------------------
        /**
         * 订单延迟插件消息队列所绑定的交换机
         */
        @Bean
        CustomExchange  orderPluginDirect() {
            //创建一个自定义交换机，可以发送延迟消息
            Map<String, Object> args = new HashMap<>();
            args.put("x-delayed-type", "direct");
            return new CustomExchange(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getExchange(), "x-delayed-message",true, false,args);
        }

        /**
         * 订单延迟插件队列
         */
        @Bean
        public Queue orderPluginQueue() {
            return new Queue(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getName());
        }

        /**
         * 将订单延迟插件队列绑定到交换机
         */
        @Bean
        public Binding orderPluginBinding(CustomExchange orderPluginDirect,Queue orderPluginQueue) {
            return BindingBuilder
                    .bind(orderPluginQueue)
                    .to(orderPluginDirect)
                    .with(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getRouteKey())
                    .noargs();
        }

    }



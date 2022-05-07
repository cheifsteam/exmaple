package com.example.mallrabbitmq.controller;

import com.example.mallrabbitmq.dto.OrderParam;
import com.example.mallrabbitmq.service.OmsPortalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Controller

@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
 private OmsPortalOrderService omsPortalOrderService;
@PostMapping("/generateOrder")
@ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return omsPortalOrderService.generateOrder(orderParam);
    }
}

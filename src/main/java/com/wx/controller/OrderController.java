package com.wx.controller;

import com.wx.service.OrdersService;
import com.wx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderController")
public class OrderController {
@Autowired
    private OrdersService ordersService;
    private ProductService productService;
}

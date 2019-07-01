package com.wx.controller;

import com.wx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productController")
public class ProductController {
@Autowired
private ProductService productService;
}

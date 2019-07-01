package com.wx.service;

import com.wx.model.dto.OrderDto;

import java.util.List;

public interface OrdersService {
    //显示所有的订单
    List<OrderDto> list(int userId);

    //取消订单
    void delete(int id);

    //产生订单
    void add(OrderDto orderDto);
}

package com.wx.service.impl;

import com.wx.dao.OrderDao;
import com.wx.model.dto.OrderDto;
import com.wx.model.entity.Order;
import com.wx.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrderDao orderDao;
    @Override
    public List<OrderDto> list(int userId) {
        String hql="from Order  o where o.id="+userId;
        List<Order> orderList=orderDao.find(hql);
        return this.e2d(orderList);
    }

    @Override
    public void delete(int id) {
        if (id==0){
        return;
        }
        Order order=orderDao.get(Order.class,id);
        orderDao.delete(order);
    }

    @Override
    public void add(OrderDto orderDto) {
        Order order=this.d2e(orderDto);
        orderDao.save(order);
    }

    private Order d2e(OrderDto orderDto) {
        Order order=new Order();
        if (orderDto!=null){
            BeanUtils.copyProperties(orderDto,order);
        }
        return order;
    }

    private OrderDto e2d(Order order){
        OrderDto orderDto=new OrderDto();
        if (order!=null){
            BeanUtils.copyProperties(order,orderDto);
        }
        return orderDto;
    }

    private List<OrderDto> e2d(List<Order> orderList) {
        List<OrderDto> orderDtos=new ArrayList<>();
        if (orderList!=null){
         for (Order o:orderList){
             orderDtos.add(this.e2d(o));
         }
        }
        return orderDtos;
    }

}

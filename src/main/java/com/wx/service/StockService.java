package com.wx.service;

import com.wx.model.dto.StockDto;

import java.util.List;

public interface StockService {
    //根据产品的id查看该产品的库存
    List<StockDto> list(int productId);

    //库存-1
    void reduce(int id);
}

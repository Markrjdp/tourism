package com.wx.service;

import com.wx.model.dto.ValueDto;

import java.util.List;

public interface ValueService {
    //查看某个产品的价格
    List<ValueDto> listValueByStock(int StockId);
}

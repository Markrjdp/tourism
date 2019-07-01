package com.wx.service;

import com.wx.model.dto.ProductDto;

import java.util.List;
import java.util.Map;

/**
 * @author dqb
 */
public interface ProductService {
    //列出所有的产品
    List<ProductDto> list(int feature_id);

    //根据关键词搜索产品
    List<ProductDto> query(String searchText);

    //查看某一个产品的信息
    List<ProductDto> get(int id);
}

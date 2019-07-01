package com.wx.service.impl;

import com.wx.dao.ProductDao;
import com.wx.model.dto.OrderDto;
import com.wx.model.dto.ProductDto;
import com.wx.model.entity.Order;
import com.wx.model.entity.Product;
import com.wx.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<ProductDto> list(int feature_id) {
        String hql="from product p where p.feature.id="+feature_id;
        List<Product> products=productDao.find(hql);
        return this.e2d(products);
    }

    @Override
    public List<ProductDto> query(String searchText) {
        int type=0;
        try {
            if (searchText=="门票"){
                type=0;
            }
            else {
                type=1;
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        String hql="from Product p where p.name=:searchText or " +
                "p.type="+type;
        List<Product> productList=productDao.find(hql);
        return this.e2d(productList);
    }

    @Override
    public List<ProductDto> get(int id) {
        String hql="from Product";
        List<Product> products=productDao.find(hql);
        return this.e2d(products);
    }



    private ProductDto e2d(Product product){
        ProductDto productDto=new ProductDto();
        if (product!=null){
            BeanUtils.copyProperties(product,productDto);
        }
        return productDto;
    }

    private List<ProductDto> e2d(List<Product> productList) {
        List<ProductDto> productDtos=new ArrayList<>();
        if (productList!=null){
            for (Product p:productList){
                productDtos.add(this.e2d(p));
            }
        }
        return productDtos;
    }

}

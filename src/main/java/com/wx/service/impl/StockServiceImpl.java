package com.wx.service.impl;

import com.wx.dao.StockDao;
import com.wx.model.dto.StockDto;
import com.wx.model.entity.Stock;
import com.wx.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    StockDao stockDao;
    @Override
    public List<StockDto> list(int productId) {
        String hql="from Stock s where s.product.id="+productId;
        List<Stock> stockList=stockDao.find(hql);
        return this.e2d(stockList);
}

    @Override
    public void reduce(int id) {
        String hql="from Stork s where s.id="+id;
        Stock stock=stockDao.get(hql);
        int s=stock.getStock()-1;
        stock.setStock(s);
    }


    private StockDto e2d(Stock stockList) {
        StockDto stockDto=new StockDto();
        if (stockList!=null){
            BeanUtils.copyProperties(stockList,stockDto);
        }
        return stockDto;
    }

    private List<StockDto> e2d(List<Stock> stockList) {
        List<StockDto> stockDtoList=new ArrayList<>();
        if (stockList!=null){
            for (Stock s:stockList){
                stockDtoList.add(this.e2d(s));
            }
        }
        return stockDtoList;
    }

}

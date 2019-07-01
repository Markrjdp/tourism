package com.wx.service.impl;

import com.wx.dao.ValueDao;
import com.wx.model.dto.ValueDto;
import com.wx.model.entity.Value;
import com.wx.service.ValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ValueServiceImpl implements ValueService {
    @Autowired
    ValueDao valueDao;
    @Override
    //根据stockid获取相应的价格信息
    public List<ValueDto> listValueByStock(int StockId) {

        String hql="from Value v where v.stockId="+StockId;
        Map<String,Object> map=new HashMap<>();
        map.put("stockId",StockId);
        List<Value> values=valueDao.find(hql,map);
        if(values!=null) {
            return this.e2d(values);
        }
        return null;
    }


    private ValueDto e2d(Value value){
        ValueDto valueDto=new ValueDto();
        if (value!=null){
            BeanUtils.copyProperties(value,valueDto);
            if (value.getStock()!=null){
                valueDto.setStockId(value.getStock().getId());
            }
        }
        return valueDto;
    }


    //    private List<MeterDto> e2d(List<Meter> meters){
//        List<MeterDto> meterDtos = new ArrayList<>();
//        if (meters != null && meters.size() != 0){
//            for (Meter m : meters){
//                meterDtos.add(this.e2d(m));
//            }
//        }
//        return meterDtos;
//    }
    private List<ValueDto> e2d(List<Value> values){
        List<ValueDto> valueDtos=new ArrayList<>();
        if (values!=null&&values.size()!=0){
            for (Value v:values){
                valueDtos.add(this.e2d(v));
            }
        }
        return valueDtos;
    }

}

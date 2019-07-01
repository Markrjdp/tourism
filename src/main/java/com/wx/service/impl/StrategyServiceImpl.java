package com.wx.service.impl;

import com.wx.dao.StrategyDao;
import com.wx.model.dto.StrategyDto;
import com.wx.model.entity.Strategy;
import com.wx.service.StrategyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    StrategyDao strategyDao;
    @Override
    public StrategyDto get(int id) {
        String hql="from Strategy s where s.id="+id;
        Strategy strategy=strategyDao.get(hql);
        return e2d(strategy);
    }

//    @Override
//    public List<StrategyDto> list(String feature) {
//        String hql="from Strategy s where s.";
//        return null;
//    }

    @Override
    public void add(StrategyDto strategyDto) {
        Strategy strategy=this.d2e(strategyDto);
        if (strategy!=null){
            strategyDao.save(strategy);
        }
    }
    @Override
    public void thumbUp(StrategyDto strategyDto) {
        Strategy strategy=d2e(strategyDto);
        int r=strategy.getThumbUp()+1;
        strategy.setThumbUp(r);
    }

    private StrategyDto e2d(Strategy strategy) {
        StrategyDto strategyDto=new StrategyDto();
        if (strategy!=null){
            BeanUtils.copyProperties(strategy,strategyDto);
        }
        return strategyDto;
    }

    private Strategy d2e(StrategyDto strategyDto) {
        Strategy strategy=new Strategy();
        if (strategyDto!=null){
            BeanUtils.copyProperties(strategyDto,strategy);
        }
        return strategy;
    }

}

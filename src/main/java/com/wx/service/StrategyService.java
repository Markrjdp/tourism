package com.wx.service;

import com.wx.model.dto.StrategyDto;

import java.util.List;

public interface StrategyService {
    //获取一个strategy的具体信息
    StrategyDto get(int id);
//
//    //列出某个城市的旅游攻略
//    List<StrategyDto> list(String feature);

    //某个用户撰写旅游攻略
    void add(StrategyDto strategyDto);

    //点赞某篇攻略
    void thumbUp(StrategyDto strategyDto);
}

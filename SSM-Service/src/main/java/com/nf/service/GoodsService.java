package com.nf.service;

import com.nf.luoliyi.entities.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAllGoods();
    int insert(Goods goods);
    int delete(int id);
    int update(Goods goods);
    Goods  selectOneById(int id);
    int deleteAll( List<Integer> items);
    List<Goods> selectAllGoodsByPage(int pagelimit,int size);
}

package com.nf.impl;

import com.nf.Interfaces.IGoodsMapper;
import com.nf.luoliyi.entities.Goods;
import com.nf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    IGoodsMapper goodsMapper;

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int delete(int id) {
        return goodsMapper.delete(id);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public Goods selectOneById(int id) {
        if(StringUtils.isEmpty(id)){
            id=1;
        }
        return goodsMapper.selectOneById(id);
    }

    @Override
    public int deleteAll(List<Integer> items) {
        return goodsMapper.deleteAll(items);
    }

    @Override
    public List<Goods> selectAllGoodsByPage(int pagelimit, int size) {
        //分页条件查询
        int limitpage=(pagelimit-1)*size;
        return goodsMapper.selectAllGoodsByPage(limitpage,size);
    }
}

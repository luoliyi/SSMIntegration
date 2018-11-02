package com.nf.Test;

import com.nf.Interfaces.IGoodsMapper;
import com.nf.luoliyi.entities.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class ApplicationTest {

   // @Autowired
    //IGoodsMapper iGoodsMapper;

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        IGoodsMapper goodsMapper=applicationContext.getBean(IGoodsMapper.class);
        List<Goods>goodsList=goodsMapper.selectAllGoods();
        System.out.println(goodsList);
    }
}
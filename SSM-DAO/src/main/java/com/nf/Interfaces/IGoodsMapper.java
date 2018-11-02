package com.nf.Interfaces;

import com.nf.luoliyi.entities.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsMapper {

    int insert(Goods goods);
    int update(Goods goods);
    int delete(@Param("id") int id);
    List<Goods> selectAllGoods();
    Goods selectOneById(@Param("id") int id);
    int deleteAll(@Param("ids") List<Integer>items);
    List<Goods>selectAllGoodsByPage(@Param("pagelimit")int pagelimit,@Param("size")int size);
}

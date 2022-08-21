package com.cm.order.center.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车加车商品分类
 */
@Data
public class CartGoodsTypeVo implements Serializable {

    private List<CartGooodsVo> comGoodsList;

    private List<CartGooodsVo> actGoodsList;

    private List<CartGooodsVo> batGoodsList;

    public CartGoodsTypeVo(){
        comGoodsList = new ArrayList<>();
        actGoodsList = new ArrayList<>();
        batGoodsList = new ArrayList<>();
    }

    public void addVo(CartGooodsVo vo){
        if(vo.getSelltype() == 1){
            comGoodsList.add(vo);
        }else if(vo.getSelltype() == 2){
            actGoodsList.add(vo);
        }else if(vo.getSelltype() == 3){
            batGoodsList.add(vo);
        }
    }
}

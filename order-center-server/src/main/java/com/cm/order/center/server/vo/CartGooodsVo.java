package com.cm.order.center.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员加入购物车的商品实体
 */
@Data
public class CartGooodsVo implements Serializable {

    /**购物序列*/
    private Long cartSeq;

    /**商品编码*/
    private Integer goodsCode;

    /**商品名称*/
    private String goodsName;

    /**商品图片*/
    private String goodsImg;

    /**购买数量*/
    private Integer buyCounts;

    /**加车日期*/
    private String cartDate;

    /**附加参数*/
    private String additional;

    /**销售类型：1，普通销售；2，活动销售；3，批发销售*/
    private Integer selltype;

    /**商品价格*/
    private BigDecimal goodsPrice;

    /**活动价格*/
    private BigDecimal activityPrice;

    /**起批数量*/
    private Integer batchCount = 1;

    /**批发价格*/
    private BigDecimal batchPrice;

    /**加车状态：1，初始化； 2，活动结束；3，批发终止；4，已下单:*/
    private Integer cartStatus;

}

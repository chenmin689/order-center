/**
* @Title: OtcOrderDetailVo
* @Package com.cm.order.center.dao.vo
* @Description: 订单明细表--实体类
* @author chenmin
* @date Sun Sep 04 16:56:22 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcOrderDetailTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcOrderDetailVo
 * @Description: 订单明细表--实体类
 * @author chenmin
 * @date Sun Sep 04 16:56:22 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_detail")
public class OtcOrderDetailVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**明细序列:detail_seq*/
	private Integer detailSeq;

	/**会员ID:user_id*/
	private Integer userId;

	/**订单号:order_no*/
	private String orderNo;

	/**子订单号:child_order_no*/
	private String childOrderNo;

	/**销售类型：1，普通销售；2，活动销售；3，批发销售:sell_type*/
	private Integer sellType;

	private String sellTypeText; 
	public String getSellTypeText(){ 
		return OtcOrderDetailTypes.sellTypeTypes.get(sellType);
	}
	/**商品名称:goods_name*/
	private String goodsName;

	/**商品编码:goods_code*/
	private Integer goodsCode;

	/**商品图片:goods_img*/
	private String goodsImg;

	/**商品价格:goods_price*/
	private BigDecimal goodsPrice;

	/**批发价格:batch_price*/
	private BigDecimal batchPrice;

	/**商品数量:goods_count*/
	private Integer goodsCount;

	/**商品总金额:goods_money*/
	private BigDecimal goodsMoney;

	/**折扣比例:discount_rate*/
	private BigDecimal discountRate;

	/**折后金额:discount_moeny*/
	private BigDecimal discountMoeny;

	/**创建时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}

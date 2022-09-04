/**
* @Title: OtcOrderVo
* @Package com.cm.order.center.dao.vo
* @Description: 会员订单管理--实体类
* @author chenmin
* @date Sun Sep 04 16:53:47 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcOrderTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcOrderVo
 * @Description: 会员订单管理--实体类
 * @author chenmin
 * @date Sun Sep 04 16:53:47 CST 2022
 */
@Data 
@TableNames(tableName="otc_order")
public class OtcOrderVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**订单序列:order_seq*/
	private Integer orderSeq;

	/**订单号:order_no*/
	private String orderNo;

	/**业务员:salesman*/
	private Integer salesman;

	/**订单类型：1，普通订单；2，批发订单:order_type*/
	private Integer orderType;

	private String orderTypeText; 
	public String getOrderTypeText(){ 
		return OtcOrderTypes.orderTypeTypes.get(orderType);
	}
	/**业务线编码:business_code*/
	private String businessCode;

	/**订单金额:order_money*/
	private BigDecimal orderMoney;

	/**折扣比例:discount_rate*/
	private BigDecimal discountRate;

	/**折后金额:discount_money*/
	private BigDecimal discountMoney;

	/**优惠金额:prefer_money*/
	private BigDecimal preferMoney;

	/**运输费用:post_money*/
	private BigDecimal postMoney;

	/**收货地址:recieve_addr*/
	private Integer recieveAddr;

	/**支付金额:pay_money*/
	private BigDecimal payMoney;

	/**支付方式：1，在线支付；2，货到付款:pay_model*/
	private Integer payModel;

	private String payModelText; 
	public String getPayModelText(){ 
		return OtcOrderTypes.payModelTypes.get(payModel);
	}
	/**支付时间:pay_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date payTime;

	/**发货时间:send_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date sendTime;

	/**交易完成时间:finish_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date finishTime;

	/**订单状态：0，已取消；10，未付款；20，已付款；40，已发货；50，交易成功；60，交易关闭:order_status*/
	private Integer orderStatus;

	private String orderStatusText; 
	public String getOrderStatusText(){ 
		return OtcOrderTypes.orderStatusTypes.get(orderStatus);
	}
	/**创建时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}

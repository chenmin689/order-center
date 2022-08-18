/**
* @Title: OtcOrderPo
* @Package com.cm.order.center.dao.po
* @Description: 会员订单管理--实体类
* @author chenmin
* @date Thu Aug 18 11:08:17 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.po;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.annotation.TableColumnName;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import lombok.Data;

/** 
 * @ClassName: OtcOrderPo
 * @Description: 会员订单管理--实体类
 * @author chenmin
 * @date Thu Aug 18 11:08:17 CST 2022
 */
@Data 
@TableNames(tableName="otc_order",serMapperName="otcOrderSerMapper",editMapperName="otcOrderEditMapper")
public class OtcOrderPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**订单序列:order_seq*/
	@TableColumnName(columnName="order_seq",jdbcType="INTEGER")
	private Integer orderSeq;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**业务员:salesman*/
	@TableColumnName(columnName="salesman",jdbcType="INTEGER")
	private Integer salesman;

	/**订单类型：1，普通订单；2，批发订单:order_type*/
	@TableColumnName(columnName="order_type",jdbcType="INTEGER")
	private Integer orderType;

	/**业务线编码:business_code*/
	@TableColumnName(columnName="business_code",jdbcType="VARCHAR")
	private String businessCode;

	/**订单金额:order_money*/
	@TableColumnName(columnName="order_money",jdbcType="DECIMAL")
	private BigDecimal orderMoney;

	/**折扣比例:discount_rate*/
	@TableColumnName(columnName="discount_rate",jdbcType="DECIMAL")
	private BigDecimal discountRate;

	/**折后金额:discount_money*/
	@TableColumnName(columnName="discount_money",jdbcType="DECIMAL")
	private BigDecimal discountMoney;

	/**优惠金额:prefer_money*/
	@TableColumnName(columnName="prefer_money",jdbcType="DECIMAL")
	private BigDecimal preferMoney;

	/**运输费用:post_money*/
	@TableColumnName(columnName="post_money",jdbcType="DECIMAL")
	private BigDecimal postMoney;

	/**收货地址:recieve_addr*/
	@TableColumnName(columnName="recieve_addr",jdbcType="INTEGER")
	private Integer recieveAddr;

	/**支付金额:pay_money*/
	@TableColumnName(columnName="pay_money",jdbcType="DECIMAL")
	private BigDecimal payMoney;

	/**支付方式：1，在线支付；2，货到付款:pay_model*/
	@TableColumnName(columnName="pay_model",jdbcType="INTEGER")
	private Integer payModel;

	/**支付时间:pay_time*/
	@TableColumnName(columnName="pay_time",jdbcType="TIMESTAMP")
	private Date payTime;

	/**发货时间:send_time*/
	@TableColumnName(columnName="send_time",jdbcType="TIMESTAMP")
	private Date sendTime;

	/**交易完成时间:finish_time*/
	@TableColumnName(columnName="finish_time",jdbcType="TIMESTAMP")
	private Date finishTime;

	/**订单状态：0，已取消；10，未付款；20，已付款；40，已发货；50，交易成功；60，交易关闭:order_status*/
	@TableColumnName(columnName="order_status",jdbcType="INTEGER")
	private Integer orderStatus;

	/**创建时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

	/**修改时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

}

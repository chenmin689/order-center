/**
* @Title: OtcOrderPaymentPo
* @Package com.cm.order.center.dao.po
* @Description: 订单支付表--实体类
* @author chenmin
* @date Thu Aug 18 09:09:05 CST 2022
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
 * @ClassName: OtcOrderPaymentPo
 * @Description: 订单支付表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:09:05 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_payment",serMapperName="otcOrderPaymentSerMapper",editMapperName="otcOrderPaymentEditMapper")
public class OtcOrderPaymentPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**支付号:pay_no*/
	@TableColumnName(columnName="pay_no",jdbcType="INTEGER")
	private Integer payNo;

	/**交易流水号:trans_no*/
	@TableColumnName(columnName="trans_no",jdbcType="VARCHAR")
	private String transNo;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**交易金额:trans_money*/
	@TableColumnName(columnName="trans_money",jdbcType="DECIMAL")
	private BigDecimal transMoney;

	/**支付方式：1，微信支付:pay_model*/
	@TableColumnName(columnName="pay_model",jdbcType="INTEGER")
	private Integer payModel;

	/**供应商编号:supplier_no*/
	@TableColumnName(columnName="supplier_no",jdbcType="VARCHAR")
	private String supplierNo;

	/**商户号:merchant_code*/
	@TableColumnName(columnName="merchant_code",jdbcType="VARCHAR")
	private String merchantCode;

	/**银行编码:bank_code*/
	@TableColumnName(columnName="bank_code",jdbcType="VARCHAR")
	private String bankCode;

	/**供应商流水号:merchant_no*/
	@TableColumnName(columnName="merchant_no",jdbcType="VARCHAR")
	private String merchantNo;

	/**交易明细:trans_detail*/
	@TableColumnName(columnName="trans_detail",jdbcType="VARCHAR")
	private String transDetail;

	/**交易状态:trans_status*/
	@TableColumnName(columnName="trans_status",jdbcType="INTEGER")
	private Integer transStatus;

	/**支付时间:pay_time*/
	@TableColumnName(columnName="pay_time",jdbcType="TIMESTAMP")
	private Date payTime;

	/**标志位：1，初始化；2，待执行；3，执行中；4，执行成功；5，执行失败:lock_flg*/
	@TableColumnName(columnName="lock_flg",jdbcType="INTEGER")
	private Integer lockFlg;

	/**执行次数:run_count*/
	@TableColumnName(columnName="run_count",jdbcType="INTEGER")
	private Integer runCount;

	/**锁定记录的时间:lock_time*/
	@TableColumnName(columnName="lock_time",jdbcType="TIMESTAMP")
	private Date lockTime;

	/**添加时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

	/**更新时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

}

/**
* @Title: OtcOrderPaymentVo
* @Package com.cm.order.center.dao.vo
* @Description: 订单支付表--实体类
* @author chenmin
* @date Thu Aug 18 09:09:05 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcOrderPaymentTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcOrderPaymentVo
 * @Description: 订单支付表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:09:05 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_payment")
public class OtcOrderPaymentVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**支付号:pay_no*/
	private Integer payNo;

	/**交易流水号:trans_no*/
	private String transNo;

	/**订单号:order_no*/
	private String orderNo;

	/**交易金额:trans_money*/
	private BigDecimal transMoney;

	/**支付方式：1，微信支付:pay_model*/
	private Integer payModel;

	private String payModelText; 
	public String getPayModelText(){ 
		return OtcOrderPaymentTypes.payModelTypes.get(payModel);
	}
	/**供应商编号:supplier_no*/
	private String supplierNo;

	/**商户号:merchant_code*/
	private String merchantCode;

	/**银行编码:bank_code*/
	private String bankCode;

	/**供应商流水号:merchant_no*/
	private String merchantNo;

	/**交易明细:trans_detail*/
	private String transDetail;

	/**交易状态:trans_status*/
	private Integer transStatus;

	private String transStatusText; 
	public String getTransStatusText(){ 
		return OtcOrderPaymentTypes.transStatusTypes.get(transStatus);
	}
	/**支付时间:pay_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date payTime;

	/**标志位：1，初始化；2，待执行；3，执行中；4，执行成功；5，执行失败:lock_flg*/
	private Integer lockFlg;

	private String lockFlgText; 
	public String getLockFlgText(){ 
		return OtcOrderPaymentTypes.lockFlgTypes.get(lockFlg);
	}
	/**执行次数:run_count*/
	private Integer runCount;

	/**锁定记录的时间:lock_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date lockTime;

	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**更新时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}

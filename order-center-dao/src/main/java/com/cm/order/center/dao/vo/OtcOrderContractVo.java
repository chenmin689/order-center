/**
* @Title: OtcOrderContractVo
* @Package com.cm.order.center.dao.vo
* @Description: 订单履约表--实体类
* @author chenmin
* @date Thu Aug 18 09:18:47 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcOrderContractTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcOrderContractVo
 * @Description: 订单履约表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:18:47 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_contract")
public class OtcOrderContractVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**履约序列:contract_seq*/
	private Integer contractSeq;

	/**履约单号:contract_no*/
	private String contractNo;

	/**订单号:order_no*/
	private String orderNo;

	/**子订单号:child_order_no*/
	private String childOrderNo;

	/**收货人:reciever*/
	private String reciever;

	/**联系电话:telephone*/
	private String telephone;

	/**收货地址:recieve_addr*/
	private String recieveAddr;

	/**配送方式:delivery_model*/
	private Integer deliveryModel;

	private String deliveryModelText; 
	public String getDeliveryModelText(){ 
		return OtcOrderContractTypes.deliveryModelTypes.get(deliveryModel);
	}
	/**配送人:delivery_person*/
	private String deliveryPerson;

	/**配送人号码:delivery_mobile*/
	private String deliveryMobile;

	/**三方物流:third_post*/
	private String thirdPost;

	/**物流运单号:post_no*/
	private String postNo;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}

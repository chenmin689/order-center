/**
* @Title: OtcOrderContractPo
* @Package com.cm.order.center.dao.po
* @Description: 订单履约表--实体类
* @author chenmin
* @date Thu Aug 18 09:18:47 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.po;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.annotation.TableColumnName;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import lombok.Data;

/** 
 * @ClassName: OtcOrderContractPo
 * @Description: 订单履约表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:18:47 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_contract",serMapperName="otcOrderContractSerMapper",editMapperName="otcOrderContractEditMapper")
public class OtcOrderContractPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**履约序列:contract_seq*/
	@TableColumnName(columnName="contract_seq",jdbcType="INTEGER")
	private Integer contractSeq;

	/**履约单号:contract_no*/
	@TableColumnName(columnName="contract_no",jdbcType="VARCHAR")
	private String contractNo;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**子订单号:child_order_no*/
	@TableColumnName(columnName="child_order_no",jdbcType="VARCHAR")
	private String childOrderNo;

	/**收货人:reciever*/
	@TableColumnName(columnName="reciever",jdbcType="VARCHAR")
	private String reciever;

	/**联系电话:telephone*/
	@TableColumnName(columnName="telephone",jdbcType="VARCHAR")
	private String telephone;

	/**收货地址:recieve_addr*/
	@TableColumnName(columnName="recieve_addr",jdbcType="VARCHAR")
	private String recieveAddr;

	/**配送方式:delivery_model*/
	@TableColumnName(columnName="delivery_model",jdbcType="INTEGER")
	private Integer deliveryModel;

	/**配送人:delivery_person*/
	@TableColumnName(columnName="delivery_person",jdbcType="VARCHAR")
	private String deliveryPerson;

	/**配送人号码:delivery_mobile*/
	@TableColumnName(columnName="delivery_mobile",jdbcType="VARCHAR")
	private String deliveryMobile;

	/**三方物流:third_post*/
	@TableColumnName(columnName="third_post",jdbcType="VARCHAR")
	private String thirdPost;

	/**物流运单号:post_no*/
	@TableColumnName(columnName="post_no",jdbcType="VARCHAR")
	private String postNo;

	/**修改时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

	/**添加时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

}

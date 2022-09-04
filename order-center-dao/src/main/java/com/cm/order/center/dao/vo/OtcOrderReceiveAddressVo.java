/**
* @Title: OtcOrderReceiveAddressVo
* @Package com.cm.order.center.dao.vo
* @Description: 订单收货地址表--实体类
* @author chenmin
* @date Sun Sep 04 16:56:52 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcOrderReceiveAddressVo
 * @Description: 订单收货地址表--实体类
 * @author chenmin
 * @date Sun Sep 04 16:56:52 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_receive_address")
public class OtcOrderReceiveAddressVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**地址序号:addr_seq*/
	private Integer addrSeq;

	/**订单号:order_no*/
	private String orderNo;

	/**收货人:receiver*/
	private String receiver;

	/**联系电话:telephone*/
	private String telephone;

	/**省份编码:province_code*/
	private Integer provinceCode;

	/**城市编码:city_code*/
	private Integer cityCode;

	/**县区编码:county_code*/
	private Integer countyCode;

	/**镇乡编码:town_code*/
	private Integer townCode;

	/**街道编码:street_code*/
	private String streetCode;

	/**详细地址:detail_addr*/
	private String detailAddr;

	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}

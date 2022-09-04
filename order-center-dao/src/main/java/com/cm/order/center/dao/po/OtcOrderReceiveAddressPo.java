/**
* @Title: OtcOrderReceiveAddressPo
* @Package com.cm.order.center.dao.po
* @Description: 订单收货地址表--实体类
* @author chenmin
* @date Sun Sep 04 16:56:52 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.po;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.annotation.TableColumnName;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import lombok.Data;

/** 
 * @ClassName: OtcOrderReceiveAddressPo
 * @Description: 订单收货地址表--实体类
 * @author chenmin
 * @date Sun Sep 04 16:56:52 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_receive_address",serMapperName="otcOrderReceiveAddressSerMapper",editMapperName="otcOrderReceiveAddressEditMapper")
public class OtcOrderReceiveAddressPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**地址序号:addr_seq*/
	@TableColumnName(columnName="addr_seq",jdbcType="INTEGER")
	private Integer addrSeq;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**收货人:receiver*/
	@TableColumnName(columnName="receiver",jdbcType="VARCHAR")
	private String receiver;

	/**联系电话:telephone*/
	@TableColumnName(columnName="telephone",jdbcType="VARCHAR")
	private String telephone;

	/**省份编码:province_code*/
	@TableColumnName(columnName="province_code",jdbcType="INTEGER")
	private Integer provinceCode;

	/**城市编码:city_code*/
	@TableColumnName(columnName="city_code",jdbcType="INTEGER")
	private Integer cityCode;

	/**县区编码:county_code*/
	@TableColumnName(columnName="county_code",jdbcType="INTEGER")
	private Integer countyCode;

	/**镇乡编码:town_code*/
	@TableColumnName(columnName="town_code",jdbcType="INTEGER")
	private Integer townCode;

	/**街道编码:street_code*/
	@TableColumnName(columnName="street_code",jdbcType="VARCHAR")
	private String streetCode;

	/**详细地址:detail_addr*/
	@TableColumnName(columnName="detail_addr",jdbcType="VARCHAR")
	private String detailAddr;

	/**添加时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

	/**修改时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

}

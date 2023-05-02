/**
* @Title: OtcCityPostCostPo
* @Package com.cm.order.center.dao.po
* @Description: 城市物流费用配置--实体类
* @author chenmin
* @date Tue May 02 16:17:14 CST 2023
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
 * @ClassName: OtcCityPostCostPo
 * @Description: 城市物流费用配置--实体类
 * @author chenmin
 * @date Tue May 02 16:17:14 CST 2023
 */
@Data 
@TableNames(tableName="otc_city_post_cost",serMapperName="otcCityPostCostSerMapper",editMapperName="otcCityPostCostEditMapper")
public class OtcCityPostCostPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**费用序号:cost_seq*/
	@TableColumnName(columnName="cost_seq",jdbcType="INTEGER")
	private Integer costSeq;

	/**业务线编码:business_code*/
	@TableColumnName(columnName="business_code",jdbcType="VARCHAR")
	private String businessCode;

	/**省份编码:province_code*/
	@TableColumnName(columnName="province_code",jdbcType="INTEGER")
	private Integer provinceCode;

	/**城市编码:city_code*/
	@TableColumnName(columnName="city_code",jdbcType="INTEGER")
	private Integer cityCode;

	/**县区编码:county_code*/
	@TableColumnName(columnName="county_code",jdbcType="INTEGER")
	private Integer countyCode;

	/**费用额度:cost*/
	@TableColumnName(columnName="cost",jdbcType="DECIMAL")
	private BigDecimal cost;

	/**配置状态：1，有效；2，无效:config_status*/
	@TableColumnName(columnName="config_status",jdbcType="INTEGER")
	private Integer configStatus;

	/**添加时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

	/**修改时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

	/**操作人:opt_name*/
	@TableColumnName(columnName="opt_name",jdbcType="INTEGER")
	private Integer optName;

}

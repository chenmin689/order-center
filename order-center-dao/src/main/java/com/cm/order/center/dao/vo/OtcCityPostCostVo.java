/**
* @Title: OtcCityPostCostVo
* @Package com.cm.order.center.dao.vo
* @Description: 城市物流费用配置--实体类
* @author chenmin
* @date Tue May 02 16:17:14 CST 2023
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcCityPostCostTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcCityPostCostVo
 * @Description: 城市物流费用配置--实体类
 * @author chenmin
 * @date Tue May 02 16:17:14 CST 2023
 */
@Data 
@TableNames(tableName="otc_city_post_cost")
public class OtcCityPostCostVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**费用序号:cost_seq*/
	private Integer costSeq;

	/**业务线编码:business_code*/
	private String businessCode;

	/**省份编码:province_code*/
	private Integer provinceCode;

	/**城市编码:city_code*/
	private Integer cityCode;

	/**县区编码:county_code*/
	private Integer countyCode;

	/**费用额度:cost*/
	private BigDecimal cost;

	/**配置状态：1，有效；2，无效:config_status*/
	private Integer configStatus;

	private String configStatusText; 
	public String getConfigStatusText(){ 
		return OtcCityPostCostTypes.configStatusTypes.get(configStatus);
	}
	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**操作人:opt_name*/
	private Integer optName;

}

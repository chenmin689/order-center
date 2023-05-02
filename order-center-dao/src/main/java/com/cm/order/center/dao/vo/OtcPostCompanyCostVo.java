/**
* @Title: OtcPostCompanyCostVo
* @Package com.cm.order.center.dao.vo
* @Description: 物流公司增值费用--实体类
* @author chenmin
* @date Tue May 02 16:18:52 CST 2023
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcPostCompanyCostVo
 * @Description: 物流公司增值费用--实体类
 * @author chenmin
 * @date Tue May 02 16:18:52 CST 2023
 */
@Data 
@TableNames(tableName="otc_post_company_cost")
public class OtcPostCompanyCostVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**物流序号:post_seq*/
	private Integer postSeq;

	/**公司编码:company_code*/
	private String companyCode;

	/**公司名称:company_name*/
	private String companyName;

	/**查询地址:query_addr*/
	private String queryAddr;

	/**增值费用:add_cost*/
	private BigDecimal addCost;

	/**客服电话:telephone*/
	private String telephone;

	/**收货员:person*/
	private String person;

	/**联系电话:mobile*/
	private String mobile;

	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**操作人:opt_name*/
	private Integer optName;

}

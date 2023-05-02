/**
* @Title: OtcPostCompanyCostPo
* @Package com.cm.order.center.dao.po
* @Description: 物流公司增值费用--实体类
* @author chenmin
* @date Tue May 02 16:18:52 CST 2023
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
 * @ClassName: OtcPostCompanyCostPo
 * @Description: 物流公司增值费用--实体类
 * @author chenmin
 * @date Tue May 02 16:18:52 CST 2023
 */
@Data 
@TableNames(tableName="otc_post_company_cost",serMapperName="otcPostCompanyCostSerMapper",editMapperName="otcPostCompanyCostEditMapper")
public class OtcPostCompanyCostPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**物流序号:post_seq*/
	@TableColumnName(columnName="post_seq",jdbcType="INTEGER")
	private Integer postSeq;

	/**公司编码:company_code*/
	@TableColumnName(columnName="company_code",jdbcType="VARCHAR")
	private String companyCode;

	/**公司名称:company_name*/
	@TableColumnName(columnName="company_name",jdbcType="VARCHAR")
	private String companyName;

	/**查询地址:query_addr*/
	@TableColumnName(columnName="query_addr",jdbcType="VARCHAR")
	private String queryAddr;

	/**增值费用:add_cost*/
	@TableColumnName(columnName="add_cost",jdbcType="DECIMAL")
	private BigDecimal addCost;

	/**客服电话:telephone*/
	@TableColumnName(columnName="telephone",jdbcType="VARCHAR")
	private String telephone;

	/**收货员:person*/
	@TableColumnName(columnName="person",jdbcType="VARCHAR")
	private String person;

	/**联系电话:mobile*/
	@TableColumnName(columnName="mobile",jdbcType="VARCHAR")
	private String mobile;

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

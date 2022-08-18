/**
* @Title: OtcPostDetailPo
* @Package com.cm.order.center.dao.po
* @Description: 物流运转明细表--实体类
* @author chenmin
* @date Thu Aug 18 09:58:57 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.po;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.annotation.TableColumnName;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import lombok.Data;

/** 
 * @ClassName: OtcPostDetailPo
 * @Description: 物流运转明细表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:58:57 CST 2022
 */
@Data 
@TableNames(tableName="otc_post_detail",serMapperName="otcPostDetailSerMapper",editMapperName="otcPostDetailEditMapper")
public class OtcPostDetailPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**运转序列:post_seq*/
	@TableColumnName(columnName="post_seq",jdbcType="INTEGER")
	private Integer postSeq;

	/**履约单号:contract_no*/
	@TableColumnName(columnName="contract_no",jdbcType="VARCHAR")
	private String contractNo;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**子订单号:child_order_no*/
	@TableColumnName(columnName="child_order_no",jdbcType="VARCHAR")
	private String childOrderNo;

	/**物流运单号:post_no*/
	@TableColumnName(columnName="post_no",jdbcType="VARCHAR")
	private String postNo;

	/**流转类型：1，已下单；2，仓库处理中；3，运输中；4，派送中；5，已签收:post_type*/
	@TableColumnName(columnName="post_type",jdbcType="INTEGER")
	private Integer postType;

	/**流转信息:post_info*/
	@TableColumnName(columnName="post_info",jdbcType="VARCHAR")
	private String postInfo;

	/**添加时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

}

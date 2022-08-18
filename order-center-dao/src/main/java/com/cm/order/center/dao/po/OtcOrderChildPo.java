/**
* @Title: OtcOrderChildPo
* @Package com.cm.order.center.dao.po
* @Description: 订单出库管理--实体类
* @author chenmin
* @date Thu Aug 18 09:15:46 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.po;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.architecture.jdbc.annotation.TableColumnName;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import lombok.Data;

/** 
 * @ClassName: OtcOrderChildPo
 * @Description: 订单出库管理--实体类
 * @author chenmin
 * @date Thu Aug 18 09:15:46 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_child",serMapperName="otcOrderChildSerMapper",editMapperName="otcOrderChildEditMapper")
public class OtcOrderChildPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**子单序列:child_seq*/
	@TableColumnName(columnName="child_seq",jdbcType="INTEGER")
	private Integer childSeq;

	/**子订单号:child_order_no*/
	@TableColumnName(columnName="child_order_no",jdbcType="VARCHAR")
	private String childOrderNo;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**配送方式：1，自己送货；2，三方送货:delivery_model*/
	@TableColumnName(columnName="delivery_model",jdbcType="INTEGER")
	private Integer deliveryModel;

	/**送达省份:in_province*/
	@TableColumnName(columnName="in_province",jdbcType="INTEGER")
	private Integer inProvince;

	/**送达城市:in_city*/
	@TableColumnName(columnName="in_city",jdbcType="INTEGER")
	private Integer inCity;

	/**出货省份:out_province*/
	@TableColumnName(columnName="out_province",jdbcType="INTEGER")
	private Integer outProvince;

	/**出货城市:out_city*/
	@TableColumnName(columnName="out_city",jdbcType="INTEGER")
	private Integer outCity;

	/**出货人:out_person*/
	@TableColumnName(columnName="out_person",jdbcType="INTEGER")
	private Integer outPerson;

	/**出货时间:out_time*/
	@TableColumnName(columnName="out_time",jdbcType="TIMESTAMP")
	private Date outTime;

	/**转移人:transfer_person*/
	@TableColumnName(columnName="transfer_person",jdbcType="INTEGER")
	private Integer transferPerson;

	/**转移原因:transfer_reason*/
	@TableColumnName(columnName="transfer_reason",jdbcType="VARCHAR")
	private String transferReason;

	/**转移时间:transfer_time*/
	@TableColumnName(columnName="transfer_time",jdbcType="TIMESTAMP")
	private Date transferTime;

	/**创建时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

}

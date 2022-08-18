/**
* @Title: OtcOrderDetailPo
* @Package com.cm.order.center.dao.po
* @Description: 订单明细表--实体类
* @author chenmin
* @date Thu Aug 18 09:10:09 CST 2022
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
 * @ClassName: OtcOrderDetailPo
 * @Description: 订单明细表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:10:09 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_detail",serMapperName="otcOrderDetailSerMapper",editMapperName="otcOrderDetailEditMapper")
public class OtcOrderDetailPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**明细序列:detail_seq*/
	@TableColumnName(columnName="detail_seq",jdbcType="INTEGER")
	private Integer detailSeq;

	/**会员ID:user_id*/
	@TableColumnName(columnName="user_id",jdbcType="INTEGER")
	private Integer userId;

	/**订单号:order_no*/
	@TableColumnName(columnName="order_no",jdbcType="VARCHAR")
	private String orderNo;

	/**子订单号:child_order_no*/
	@TableColumnName(columnName="child_order_no",jdbcType="VARCHAR")
	private String childOrderNo;

	/**商品名称:goods_name*/
	@TableColumnName(columnName="goods_name",jdbcType="VARCHAR")
	private String goodsName;

	/**商品编码:goods_code*/
	@TableColumnName(columnName="goods_code",jdbcType="INTEGER")
	private Integer goodsCode;

	/**商品图片:goods_img*/
	@TableColumnName(columnName="goods_img",jdbcType="VARCHAR")
	private String goodsImg;

	/**商品价格:goods_price*/
	@TableColumnName(columnName="goods_price",jdbcType="DECIMAL")
	private BigDecimal goodsPrice;

	/**批发价格:batch_price*/
	@TableColumnName(columnName="batch_price",jdbcType="DECIMAL")
	private BigDecimal batchPrice;

	/**商品数量:goods_count*/
	@TableColumnName(columnName="goods_count",jdbcType="INTEGER")
	private Integer goodsCount;

	/**商品总金额:goods_money*/
	@TableColumnName(columnName="goods_money",jdbcType="DECIMAL")
	private BigDecimal goodsMoney;

	/**折扣比例:discount_rate*/
	@TableColumnName(columnName="discount_rate",jdbcType="DECIMAL")
	private BigDecimal discountRate;

	/**折后金额:discount_moeny*/
	@TableColumnName(columnName="discount_moeny",jdbcType="DECIMAL")
	private BigDecimal discountMoeny;

	/**创建时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

	/**修改时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

}

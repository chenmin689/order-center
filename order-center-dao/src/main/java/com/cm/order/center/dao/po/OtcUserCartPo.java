/**
* @Title: OtcUserCartPo
* @Package com.cm.order.center.dao.po
* @Description: 会员购物车表--实体类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
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
 * @ClassName: OtcUserCartPo
 * @Description: 会员购物车表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:10:59 CST 2022
 */
@Data 
@TableNames(tableName="otc_user_cart",serMapperName="otcUserCartSerMapper",editMapperName="otcUserCartEditMapper")
public class OtcUserCartPo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**购物序列:cart_seq*/
	@TableColumnName(columnName="cart_seq",jdbcType="BIGINT")
	private Long cartSeq;

	/**会员ID:user_id*/
	@TableColumnName(columnName="user_id",jdbcType="INTEGER")
	private Integer userId;

	/**业务线编码:business_code*/
	@TableColumnName(columnName="business_code",jdbcType="VARCHAR")
	private String businessCode;

	/**商品编码:goods_code*/
	@TableColumnName(columnName="goods_code",jdbcType="INTEGER")
	private Integer goodsCode;

	private BigDecimal goodsPrice;


	/**商品名称:goods_name*/
	@TableColumnName(columnName="goods_name",jdbcType="VARCHAR")
	private String goodsName;

	/**商品图片:goods_img*/
	@TableColumnName(columnName="goods_img",jdbcType="VARCHAR")
	private String goodsImg;

	/**购买数量:buy_counts*/
	@TableColumnName(columnName="buy_counts",jdbcType="INTEGER")
	private Integer buyCounts;

	/**加车日期:cart_date*/
	@TableColumnName(columnName="cart_date",jdbcType="INTEGER")
	private Integer cartDate;

	/**附加参数:additional*/
	@TableColumnName(columnName="additional",jdbcType="VARCHAR")
	private String additional;

	/**销售类型:sellType*/
	@TableColumnName(columnName="sellType",jdbcType="INTEGER")
	private Integer selltype;

	/**活动编码:activity_code*/
	@TableColumnName(columnName="activity_code",jdbcType="VARCHAR")
	private String activityCode;

	/**活动价格:activity_price*/
	@TableColumnName(columnName="activity_price",jdbcType="DECIMAL")
	private BigDecimal activityPrice;

	/**加车状态:cart_status*/
	@TableColumnName(columnName="cart_status",jdbcType="INTEGER")
	private Integer cartStatus;

	/**添加时间:create_time*/
	@TableColumnName(columnName="create_time",jdbcType="TIMESTAMP")
	private Date createTime;

	/**修改时间:update_time*/
	@TableColumnName(columnName="update_time",jdbcType="TIMESTAMP")
	private Date updateTime;

}

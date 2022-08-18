/**
* @Title: OtcUserCartVo
* @Package com.cm.order.center.dao.vo
* @Description: 会员购物车表--实体类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcUserCartTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcUserCartVo
 * @Description: 会员购物车表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:10:59 CST 2022
 */
@Data 
@TableNames(tableName="otc_user_cart")
public class OtcUserCartVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**购物序列:cart_seq*/
	private Integer cartSeq;

	/**会员ID:user_id*/
	private Integer userId;

	/**业务线编码:business_code*/
	private String businessCode;

	/**商品编码:goods_code*/
	private Integer goodsCode;

	/**商品名称:goods_name*/
	private String goodsName;

	/**商品图片:goods_img*/
	private String goodsImg;

	/**购买数量:buy_counts*/
	private Integer buyCounts;

	/**加车日期:cart_date*/
	private Integer cartDate;

	/**附加参数:additional*/
	private String additional;

	/**销售类型:sellType*/
	private Integer selltype;

	private String selltypeText; 
	public String getSelltypeText(){ 
		return OtcUserCartTypes.selltypeTypes.get(selltype);
	}
	/**活动编码:activity_code*/
	private String activityCode;

	/**活动价格:activity_price*/
	private BigDecimal activityPrice;

	/**加车状态:cart_status*/
	private Integer cartStatus;

	private String cartStatusText; 
	public String getCartStatusText(){ 
		return OtcUserCartTypes.cartStatusTypes.get(cartStatus);
	}
	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**修改时间:update_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}

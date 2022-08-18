/**
* @Title: OtcOrderChildVo
* @Package com.cm.order.center.dao.vo
* @Description: 订单出库管理--实体类
* @author chenmin
* @date Thu Aug 18 09:15:46 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcOrderChildTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcOrderChildVo
 * @Description: 订单出库管理--实体类
 * @author chenmin
 * @date Thu Aug 18 09:15:46 CST 2022
 */
@Data 
@TableNames(tableName="otc_order_child")
public class OtcOrderChildVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**子单序列:child_seq*/
	private Integer childSeq;

	/**子订单号:child_order_no*/
	private String childOrderNo;

	/**订单号:order_no*/
	private String orderNo;

	/**配送方式：1，自己送货；2，三方送货:delivery_model*/
	private Integer deliveryModel;

	private String deliveryModelText; 
	public String getDeliveryModelText(){ 
		return OtcOrderChildTypes.deliveryModelTypes.get(deliveryModel);
	}
	/**送达省份:in_province*/
	private Integer inProvince;

	/**送达城市:in_city*/
	private Integer inCity;

	/**出货省份:out_province*/
	private Integer outProvince;

	/**出货城市:out_city*/
	private Integer outCity;

	/**出货人:out_person*/
	private Integer outPerson;

	/**出货时间:out_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date outTime;

	/**转移人:transfer_person*/
	private Integer transferPerson;

	/**转移原因:transfer_reason*/
	private String transferReason;

	/**转移时间:transfer_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date transferTime;

	/**创建时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}

/**
* @Title: OtcPostDetailVo
* @Package com.cm.order.center.dao.vo
* @Description: 物流运转明细表--实体类
* @author chenmin
* @date Thu Aug 18 09:20:39 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.vo;

import java.util.Date;
import com.cm.architecture.jdbc.annotation.TableNames;
import com.cm.order.center.dao.type.OtcPostDetailTypes;
import com.cm.architecture.jdbc.pojo.AbstractPojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/** 
 * @ClassName: OtcPostDetailVo
 * @Description: 物流运转明细表--实体类
 * @author chenmin
 * @date Thu Aug 18 09:20:39 CST 2022
 */
@Data 
@TableNames(tableName="otc_post_detail")
public class OtcPostDetailVo extends AbstractPojo {

	private static final long serialVersionUID = 1L;

	/**运转序列:post_seq*/
	private String postSeq;

	/**履约单号:contract_no*/
	private String contractNo;

	/**订单号:order_no*/
	private String orderNo;

	/**子订单号:child_order_no*/
	private String childOrderNo;

	/**物流运单号:post_no*/
	private String postNo;

	/**流转类型：1，已下单；2，仓库处理中；3，运输中；4，派送中；5，已签收:post_type*/
	private Integer postType;

	private String postTypeText; 
	public String getPostTypeText(){ 
		return OtcPostDetailTypes.postTypeTypes.get(postType);
	}
	/**流转信息:post_info*/
	private String postInfo;

	/**添加时间:create_time*/
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}

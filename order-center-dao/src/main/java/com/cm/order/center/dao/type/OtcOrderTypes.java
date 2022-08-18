/**
* @Title: OtcOrderTypes
* @Package com.cm.order.center.dao.type
* @Description: 会员订单管理--类型实体类
* @author chenmin
* @date Thu Aug 18 10:31:54 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcOrderTypes
 * @Description: 会员订单管理--类型实体类
 * @author chenmin
 * @date Thu Aug 18 10:31:54 CST 2022
 */
public class OtcOrderTypes{

	public static final Map<Integer,String> orderTypeTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"普通订单");
		put(2,"批发订单");
	}};
	public static final Map<Integer,String> payModelTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"在线支付");
		put(2,"货到付款");
	}};
	public static final Map<Integer,String> orderStatusTypes = new ConcurrentHashMap<Integer,String>(){{
		put(0,"已取消");
		put(10,"未付款");
		put(20,"已付款");
		put(40,"已发货");
		put(50,"交易成功");
		put(60,"交易关闭");
	}};
}

/**
* @Title: OtcOrderPaymentTypes
* @Package com.cm.order.center.dao.type
* @Description: 订单支付表--类型实体类
* @author chenmin
* @date Thu Aug 18 09:09:05 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcOrderPaymentTypes
 * @Description: 订单支付表--类型实体类
 * @author chenmin
 * @date Thu Aug 18 09:09:05 CST 2022
 */
public class OtcOrderPaymentTypes{

	public static final Map<Integer,String> payModelTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"微信支付");
	}};
	public static final Map<Integer,String> transStatusTypes = new ConcurrentHashMap<Integer,String>(){{
	}};
	public static final Map<Integer,String> lockFlgTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"初始化");
		put(2,"待执行");
		put(3,"执行中");
		put(4,"执行成功");
		put(5,"执行失败");
	}};
}

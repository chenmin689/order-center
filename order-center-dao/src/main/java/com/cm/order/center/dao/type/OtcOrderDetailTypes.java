/**
* @Title: OtcOrderDetailTypes
* @Package com.cm.order.center.dao.type
* @Description: 订单明细表--类型实体类
* @author chenmin
* @date Sun Sep 04 16:56:23 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcOrderDetailTypes
 * @Description: 订单明细表--类型实体类
 * @author chenmin
 * @date Sun Sep 04 16:56:23 CST 2022
 */
public class OtcOrderDetailTypes{

	public static final Map<Integer,String> sellTypeTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"普通销售");
		put(2,"活动销售");
		put(3,"批发销售");
	}};
}

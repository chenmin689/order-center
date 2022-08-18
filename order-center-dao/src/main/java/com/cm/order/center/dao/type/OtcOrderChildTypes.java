/**
* @Title: OtcOrderChildTypes
* @Package com.cm.order.center.dao.type
* @Description: 订单出库管理--类型实体类
* @author chenmin
* @date Thu Aug 18 09:15:46 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcOrderChildTypes
 * @Description: 订单出库管理--类型实体类
 * @author chenmin
 * @date Thu Aug 18 09:15:46 CST 2022
 */
public class OtcOrderChildTypes{

	public static final Map<Integer,String> deliveryModelTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"自己送货");
		put(2,"三方送货");
	}};
}

/**
* @Title: OtcCityPostCostTypes
* @Package com.cm.order.center.dao.type
* @Description: 城市物流费用配置--类型实体类
* @author chenmin
* @date Tue May 02 16:17:14 CST 2023
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcCityPostCostTypes
 * @Description: 城市物流费用配置--类型实体类
 * @author chenmin
 * @date Tue May 02 16:17:14 CST 2023
 */
public class OtcCityPostCostTypes{

	public static final Map<Integer,String> configStatusTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"有效");
		put(2,"无效");
	}};
}

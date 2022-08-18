/**
* @Title: OtcPostDetailTypes
* @Package com.cm.order.center.dao.type
* @Description: 物流运转明细表--类型实体类
* @author chenmin
* @date Thu Aug 18 09:20:39 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcPostDetailTypes
 * @Description: 物流运转明细表--类型实体类
 * @author chenmin
 * @date Thu Aug 18 09:20:39 CST 2022
 */
public class OtcPostDetailTypes{

	public static final Map<Integer,String> postTypeTypes = new ConcurrentHashMap<Integer,String>(){{
		put(1,"已下单");
		put(2,"仓库处理中");
		put(3,"运输中");
		put(4,"派送中");
		put(5,"已签收");
	}};
}

/**
* @Title: OtcUserCartTypes
* @Package com.cm.order.center.dao.type
* @Description: 会员购物车表--类型实体类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
* @version V1.0
*/

package com.cm.order.center.dao.type;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: OtcUserCartTypes
 * @Description: 会员购物车表--类型实体类
 * @author chenmin
 * @date Thu Aug 18 09:10:59 CST 2022
 */
public class OtcUserCartTypes{

	public static final Map<Integer,String> selltypeTypes = new ConcurrentHashMap<Integer,String>(){{
	}};
	public static final Map<Integer,String> cartStatusTypes = new ConcurrentHashMap<Integer,String>(){{
	}};
}

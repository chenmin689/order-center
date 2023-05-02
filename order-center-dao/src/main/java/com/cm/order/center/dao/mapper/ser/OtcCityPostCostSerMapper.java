/**
* @Title: OtcCityPostCostSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 城市物流费用配置--增删改接口类
* @author chenmin
* @date Tue May 02 16:17:14 CST 2023
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcCityPostCostVo;
import com.cm.order.center.dao.po.OtcCityPostCostPo;
import java.util.Date;
/**
* @ClassName: OtcCityPostCostSerMapper
* @Description: 城市物流费用配置--查询接口类
* @author chenmin
* @date Tue May 02 16:17:14 CST 2023
 */
public interface OtcCityPostCostSerMapper extends PersistenceSerMapper<OtcCityPostCostPo,OtcCityPostCostVo,Integer>{

}

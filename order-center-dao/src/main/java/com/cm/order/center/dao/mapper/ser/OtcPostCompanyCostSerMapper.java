/**
* @Title: OtcPostCompanyCostSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 物流公司增值费用--增删改接口类
* @author chenmin
* @date Tue May 02 16:18:52 CST 2023
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcPostCompanyCostVo;
import com.cm.order.center.dao.po.OtcPostCompanyCostPo;
import java.util.Date;
/**
* @ClassName: OtcPostCompanyCostSerMapper
* @Description: 物流公司增值费用--查询接口类
* @author chenmin
* @date Tue May 02 16:18:52 CST 2023
 */
public interface OtcPostCompanyCostSerMapper extends PersistenceSerMapper<OtcPostCompanyCostPo,OtcPostCompanyCostVo,Integer>{

}

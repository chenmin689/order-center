package com.cm.order.center.server.services;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcCityPostCostPo;
import com.cm.order.center.dao.vo.OtcCityPostCostVo;

/**
 *   城市物流费用配置  
 * @author chenmin
 */
public interface CityPostCostService {
	
	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean); 

	public ClientResponesBean<String> add(ClientRequestBean requestBean);

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcCityPostCostPo> query(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcCityPostCostVo> queryVo(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) ;

}

package com.cm.order.center.server.services;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcOrderChildPo;
import com.cm.order.center.dao.vo.OtcOrderChildVo;

/**
 *   订单出库管理  
 * @author chenmin
 */
public interface OrderChildService {
	
	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean); 

	public ClientResponesBean<String> add(ClientRequestBean requestBean);

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcOrderChildPo> query(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcOrderChildVo> queryVo(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) ;

}

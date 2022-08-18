package com.cm.order.center.server.services;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcOrderPaymentPo;
import com.cm.order.center.dao.vo.OtcOrderPaymentVo;

/**
 *   订单支付表  
 * @author chenmin
 */
public interface OrderPaymentService {
	
	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean); 

	public ClientResponesBean<String> add(ClientRequestBean requestBean);

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcOrderPaymentPo> query(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcOrderPaymentVo> queryVo(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) ;

}

package com.cm.order.center.server.services;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcOrderReceiveAddressPo;
import com.cm.order.center.dao.vo.OtcOrderReceiveAddressVo;

/**
 *   订单收货地址表  
 * @author chenmin
 */
public interface OrderReceiveAddressService {
	
	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean); 

	public ClientResponesBean<String> add(ClientRequestBean requestBean);

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcOrderReceiveAddressPo> query(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcOrderReceiveAddressVo> queryVo(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) ;

}

package com.cm.order.center.server.services;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.dao.vo.OtcUserCartVo;

/**
 *   会员购物车表  
 * @author chenmin
 */
public interface UserCartService {
	
	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean); 

	public ClientResponesBean<String> add(ClientRequestBean requestBean);

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcUserCartPo> query(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcUserCartVo> queryVo(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) ;

}

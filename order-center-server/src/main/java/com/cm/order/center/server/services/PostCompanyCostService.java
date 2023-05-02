package com.cm.order.center.server.services;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.commons.select.SelectNode;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcPostCompanyCostPo;
import com.cm.order.center.dao.vo.OtcPostCompanyCostVo;

import java.util.List;

/**
 *   物流公司增值费用  
 * @author chenmin
 */
public interface PostCompanyCostService {

	List<SelectNode> select();
	
	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean); 

	public ClientResponesBean<String> add(ClientRequestBean requestBean);

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcPostCompanyCostPo> query(ClientRequestBean requestBean) ;

	public ClientResponesBean<OtcPostCompanyCostVo> queryVo(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) ;

	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) ;

}

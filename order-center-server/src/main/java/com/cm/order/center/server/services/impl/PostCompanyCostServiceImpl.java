package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;

import com.cm.architecture.commons.select.SelectNode;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcPostCompanyCostEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcPostCompanyCostSerMapper;
import com.cm.order.center.dao.po.OtcPostCompanyCostPo;
import com.cm.order.center.dao.vo.OtcPostCompanyCostVo;
import com.cm.order.center.server.services.PostCompanyCostService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   物流公司增值费用  
 * @author chenmin
 */
@Service
@Slf4j
public class PostCompanyCostServiceImpl extends AbstractServiceImpl implements PostCompanyCostService {
	
	@Resource
	private OtcPostCompanyCostSerMapper otcPostCompanyCostSerMapper;
	
	@Resource
	private OtcPostCompanyCostEditMapper otcPostCompanyCostEditMapper;

	public List<SelectNode> select() {
		List<SelectNode> result = new ArrayList<>();
		try {
			List<OtcPostCompanyCostPo> list = otcPostCompanyCostSerMapper.byWhereQueryList(new OtcPostCompanyCostPo());
			if(!CollectionUtils.isEmpty(list)){
				list.forEach(temp ->{
					result.add(new SelectNode(temp.getCompanyCode(),temp.getCompanyName()+"（运费浮动："+temp.getAddCost()+"元）"));
				});
			}
		}catch (Exception e) {
			log.error("物流公司增值费用 ,分页查询异常：",e);
		}
		return result;
	}

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcPostCompanyCostPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("companyCode")){
				entity.setWhere("companyCode",requestBean.getStringValue("companyCode"));
			}
			if(requestBean.isNotNull("companyName")){
				entity.setWhere("companyName",requestBean.getStringValue("companyName"));
			}
			entity = this.queryPageVoList(entity, otcPostCompanyCostSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("物流公司增值费用 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcPostCompanyCostPo po = new OtcPostCompanyCostPo();
			
			po.setCompanyCode(requestBean.getStringValue("companyCode")); 
			po.setCompanyName(requestBean.getStringValue("companyName")); 
			po.setQueryAddr(requestBean.getStringValue("queryAddr")); 
			po.setAddCost(requestBean.getBigDecimalValue("addCost")); 
			po.setTelephone(requestBean.getStringValue("telephone")); 
			po.setPerson(requestBean.getStringValue("person")); 
			po.setMobile(requestBean.getStringValue("mobile")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			po.setOptName(requestBean.getIntegerValue("optName")); 
			
			otcPostCompanyCostEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("物流公司增值费用 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcPostCompanyCostPo po = new OtcPostCompanyCostPo();
			po.setPostSeq(requestBean.getIntegerValue("postSeq"));
			
			po.setCompanyCode(requestBean.getStringValue("companyCode")); 
			po.setCompanyName(requestBean.getStringValue("companyName")); 
			po.setQueryAddr(requestBean.getStringValue("queryAddr")); 
			po.setAddCost(requestBean.getBigDecimalValue("addCost")); 
			po.setTelephone(requestBean.getStringValue("telephone")); 
			po.setPerson(requestBean.getStringValue("person")); 
			po.setMobile(requestBean.getStringValue("mobile")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			po.setOptName(requestBean.getIntegerValue("optName")); 
			
			int count = otcPostCompanyCostEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("物流公司增值费用 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcPostCompanyCostPo> query(ClientRequestBean requestBean) {
		try {
			OtcPostCompanyCostPo po = otcPostCompanyCostSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("postSeq"));
			return new ClientResponesBean<OtcPostCompanyCostPo>(po);
		}catch (Exception e) {
			log.error("物流公司增值费用 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcPostCompanyCostPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcPostCompanyCostVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcPostCompanyCostVo vo = otcPostCompanyCostSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("postSeq"));
			return new ClientResponesBean<OtcPostCompanyCostVo>(vo);
		}catch (Exception e) {
			log.error("物流公司增值费用 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcPostCompanyCostVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcPostCompanyCostPo po = new OtcPostCompanyCostPo();
			po.setPostSeq(requestBean.getIntegerValue("postSeq"));
			int count = otcPostCompanyCostEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("物流公司增值费用 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcPostCompanyCostPo po = new OtcPostCompanyCostPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setPostSeq(id);
			count += otcPostCompanyCostEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("物流公司增值费用 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

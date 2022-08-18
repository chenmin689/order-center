package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcOrderContractEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcOrderContractSerMapper;
import com.cm.order.center.dao.po.OtcOrderContractPo;
import com.cm.order.center.dao.vo.OtcOrderContractVo;
import com.cm.order.center.server.services.OrderContractService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   订单履约表  
 * @author chenmin
 */
@Service
@Slf4j
public class OrderContractServiceImpl extends AbstractServiceImpl implements OrderContractService {
	
	@Resource
	private OtcOrderContractSerMapper otcOrderContractSerMapper;
	
	@Resource
	private OtcOrderContractEditMapper otcOrderContractEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcOrderContractPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			if(requestBean.isNotNull("reciever")){
				entity.setWhere("reciever",requestBean.getStringValue("reciever"));
			}
			if(requestBean.isNotNull("telephone")){
				entity.setWhere("telephone",requestBean.getStringValue("telephone"));
			}
			if(requestBean.isNotNull("postNo")){
				entity.setWhere("postNo",requestBean.getStringValue("postNo"));
			}
			entity = this.queryPageVoList(entity, otcOrderContractSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("订单履约表 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcOrderContractPo po = new OtcOrderContractPo();
			
			po.setContractNo(requestBean.getStringValue("contractNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setReciever(requestBean.getStringValue("reciever")); 
			po.setTelephone(requestBean.getStringValue("telephone")); 
			po.setRecieveAddr(requestBean.getStringValue("recieveAddr")); 
			po.setDeliveryModel(requestBean.getIntegerValue("deliveryModel")); 
			po.setDeliveryPerson(requestBean.getStringValue("deliveryPerson")); 
			po.setDeliveryMobile(requestBean.getStringValue("deliveryMobile")); 
			po.setThirdPost(requestBean.getStringValue("thirdPost")); 
			po.setPostNo(requestBean.getStringValue("postNo")); 
			po.setUpdateTime(new Date()); 
			po.setCreateTime(new Date()); 
			
			otcOrderContractEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("订单履约表 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcOrderContractPo po = new OtcOrderContractPo();
			po.setContractSeq(requestBean.getIntegerValue("contractSeq"));
			
			po.setContractNo(requestBean.getStringValue("contractNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setReciever(requestBean.getStringValue("reciever")); 
			po.setTelephone(requestBean.getStringValue("telephone")); 
			po.setRecieveAddr(requestBean.getStringValue("recieveAddr")); 
			po.setDeliveryModel(requestBean.getIntegerValue("deliveryModel")); 
			po.setDeliveryPerson(requestBean.getStringValue("deliveryPerson")); 
			po.setDeliveryMobile(requestBean.getStringValue("deliveryMobile")); 
			po.setThirdPost(requestBean.getStringValue("thirdPost")); 
			po.setPostNo(requestBean.getStringValue("postNo")); 
			po.setUpdateTime(new Date()); 
			po.setCreateTime(new Date()); 
			
			int count = otcOrderContractEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单履约表 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderContractPo> query(ClientRequestBean requestBean) {
		try {
			OtcOrderContractPo po = otcOrderContractSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("contractSeq"));
			return new ClientResponesBean<OtcOrderContractPo>(po);
		}catch (Exception e) {
			log.error("订单履约表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderContractPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderContractVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcOrderContractVo vo = otcOrderContractSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("contractSeq"));
			return new ClientResponesBean<OtcOrderContractVo>(vo);
		}catch (Exception e) {
			log.error("订单履约表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderContractVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcOrderContractPo po = new OtcOrderContractPo();
			po.setContractSeq(requestBean.getIntegerValue("contractSeq"));
			int count = otcOrderContractEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单履约表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcOrderContractPo po = new OtcOrderContractPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setContractSeq(id);
			count += otcOrderContractEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单履约表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

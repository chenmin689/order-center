package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcOrderChildEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcOrderChildSerMapper;
import com.cm.order.center.dao.po.OtcOrderChildPo;
import com.cm.order.center.dao.vo.OtcOrderChildVo;
import com.cm.order.center.server.services.OrderChildService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   订单出库管理  
 * @author chenmin
 */
@Service
@Slf4j
public class OrderChildServiceImpl extends AbstractServiceImpl implements OrderChildService {
	
	@Resource
	private OtcOrderChildSerMapper otcOrderChildSerMapper;
	
	@Resource
	private OtcOrderChildEditMapper otcOrderChildEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcOrderChildPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("childOrderNo")){
				entity.setWhere("childOrderNo",requestBean.getStringValue("childOrderNo"));
			}
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			if(requestBean.isNotNull("deliveryModel")){
				entity.setWhere("deliveryModel",requestBean.getIntegerValue("deliveryModel"));
			}
			entity = this.queryPageVoList(entity, otcOrderChildSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("订单出库管理 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcOrderChildPo po = new OtcOrderChildPo();
			
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setDeliveryModel(requestBean.getIntegerValue("deliveryModel")); 
			po.setInProvince(requestBean.getIntegerValue("inProvince")); 
			po.setInCity(requestBean.getIntegerValue("inCity")); 
			po.setOutProvince(requestBean.getIntegerValue("outProvince")); 
			po.setOutCity(requestBean.getIntegerValue("outCity")); 
			po.setOutPerson(requestBean.getIntegerValue("outPerson")); 
			po.setOutTime(new Date()); 
			po.setTransferPerson(requestBean.getIntegerValue("transferPerson")); 
			po.setTransferReason(requestBean.getStringValue("transferReason")); 
			po.setTransferTime(new Date()); 
			po.setCreateTime(new Date()); 
			
			otcOrderChildEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("订单出库管理 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcOrderChildPo po = new OtcOrderChildPo();
			po.setChildSeq(requestBean.getIntegerValue("childSeq"));
			
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setDeliveryModel(requestBean.getIntegerValue("deliveryModel")); 
			po.setInProvince(requestBean.getIntegerValue("inProvince")); 
			po.setInCity(requestBean.getIntegerValue("inCity")); 
			po.setOutProvince(requestBean.getIntegerValue("outProvince")); 
			po.setOutCity(requestBean.getIntegerValue("outCity")); 
			po.setOutPerson(requestBean.getIntegerValue("outPerson")); 
			po.setOutTime(new Date()); 
			po.setTransferPerson(requestBean.getIntegerValue("transferPerson")); 
			po.setTransferReason(requestBean.getStringValue("transferReason")); 
			po.setTransferTime(new Date()); 
			po.setCreateTime(new Date()); 
			
			int count = otcOrderChildEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单出库管理 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderChildPo> query(ClientRequestBean requestBean) {
		try {
			OtcOrderChildPo po = otcOrderChildSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("childSeq"));
			return new ClientResponesBean<OtcOrderChildPo>(po);
		}catch (Exception e) {
			log.error("订单出库管理 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderChildPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderChildVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcOrderChildVo vo = otcOrderChildSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("childSeq"));
			return new ClientResponesBean<OtcOrderChildVo>(vo);
		}catch (Exception e) {
			log.error("订单出库管理 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderChildVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcOrderChildPo po = new OtcOrderChildPo();
			po.setChildSeq(requestBean.getIntegerValue("childSeq"));
			int count = otcOrderChildEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单出库管理 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcOrderChildPo po = new OtcOrderChildPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setChildSeq(id);
			count += otcOrderChildEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单出库管理 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

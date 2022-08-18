package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcOrderEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcOrderSerMapper;
import com.cm.order.center.dao.po.OtcOrderPo;
import com.cm.order.center.dao.vo.OtcOrderVo;
import com.cm.order.center.server.services.OrderService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   会员订单管理  
 * @author chenmin
 */
@Service
@Slf4j
public class OrderServiceImpl extends AbstractServiceImpl implements OrderService {
	
	@Resource
	private OtcOrderSerMapper otcOrderSerMapper;
	
	@Resource
	private OtcOrderEditMapper otcOrderEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcOrderPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			if(requestBean.isNotNull("orderType")){
				entity.setWhere("orderType",requestBean.getIntegerValue("orderType"));
			}
			if(requestBean.isNotNull("businessCode")){
				entity.setWhere("businessCode",requestBean.getStringValue("businessCode"));
			}
			if(requestBean.isNotNull("orderStatus")){
				entity.setWhere("orderStatus",requestBean.getIntegerValue("orderStatus"));
			}
			entity = this.queryPageVoList(entity, otcOrderSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("会员订单管理 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcOrderPo po = new OtcOrderPo();
			
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setSalesman(requestBean.getIntegerValue("salesman")); 
			po.setOrderType(requestBean.getIntegerValue("orderType")); 
			po.setBusinessCode(requestBean.getStringValue("businessCode")); 
			po.setOrderMoney(requestBean.getBigDecimalValue("orderMoney")); 
			po.setDiscountRate(requestBean.getBigDecimalValue("discountRate")); 
			po.setDiscountMoney(requestBean.getBigDecimalValue("discountMoney")); 
			po.setPreferMoney(requestBean.getBigDecimalValue("preferMoney")); 
			po.setPostMoney(requestBean.getBigDecimalValue("postMoney")); 
			po.setRecieveAddr(requestBean.getIntegerValue("recieveAddr")); 
			po.setPayMoney(requestBean.getBigDecimalValue("payMoney")); 
			po.setPayModel(requestBean.getIntegerValue("payModel")); 
			po.setPayTime(new Date()); 
			po.setSendTime(new Date()); 
			po.setFinishTime(new Date()); 
			po.setOrderStatus(requestBean.getIntegerValue("orderStatus")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			otcOrderEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("会员订单管理 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcOrderPo po = new OtcOrderPo();
			po.setOrderSeq(requestBean.getIntegerValue("orderSeq"));
			
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setSalesman(requestBean.getIntegerValue("salesman")); 
			po.setOrderType(requestBean.getIntegerValue("orderType")); 
			po.setBusinessCode(requestBean.getStringValue("businessCode")); 
			po.setOrderMoney(requestBean.getBigDecimalValue("orderMoney")); 
			po.setDiscountRate(requestBean.getBigDecimalValue("discountRate")); 
			po.setDiscountMoney(requestBean.getBigDecimalValue("discountMoney")); 
			po.setPreferMoney(requestBean.getBigDecimalValue("preferMoney")); 
			po.setPostMoney(requestBean.getBigDecimalValue("postMoney")); 
			po.setRecieveAddr(requestBean.getIntegerValue("recieveAddr")); 
			po.setPayMoney(requestBean.getBigDecimalValue("payMoney")); 
			po.setPayModel(requestBean.getIntegerValue("payModel")); 
			po.setPayTime(new Date()); 
			po.setSendTime(new Date()); 
			po.setFinishTime(new Date()); 
			po.setOrderStatus(requestBean.getIntegerValue("orderStatus")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			int count = otcOrderEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("会员订单管理 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderPo> query(ClientRequestBean requestBean) {
		try {
			OtcOrderPo po = otcOrderSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("orderSeq"));
			return new ClientResponesBean<OtcOrderPo>(po);
		}catch (Exception e) {
			log.error("会员订单管理 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcOrderVo vo = otcOrderSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("orderSeq"));
			return new ClientResponesBean<OtcOrderVo>(vo);
		}catch (Exception e) {
			log.error("会员订单管理 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcOrderPo po = new OtcOrderPo();
			po.setOrderSeq(requestBean.getIntegerValue("orderSeq"));
			int count = otcOrderEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("会员订单管理 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcOrderPo po = new OtcOrderPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setOrderSeq(id);
			count += otcOrderEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("会员订单管理 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcOrderPaymentEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcOrderPaymentSerMapper;
import com.cm.order.center.dao.po.OtcOrderPaymentPo;
import com.cm.order.center.dao.vo.OtcOrderPaymentVo;
import com.cm.order.center.server.services.OrderPaymentService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   订单支付表  
 * @author chenmin
 */
@Service
@Slf4j
public class OrderPaymentServiceImpl extends AbstractServiceImpl implements OrderPaymentService {
	
	@Resource
	private OtcOrderPaymentSerMapper otcOrderPaymentSerMapper;
	
	@Resource
	private OtcOrderPaymentEditMapper otcOrderPaymentEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcOrderPaymentPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			if(requestBean.isNotNull("merchantNo")){
				entity.setWhere("merchantNo",requestBean.getStringValue("merchantNo"));
			}
			entity = this.queryPageVoList(entity, otcOrderPaymentSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("订单支付表 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcOrderPaymentPo po = new OtcOrderPaymentPo();
			
			po.setTransNo(requestBean.getStringValue("transNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setTransMoney(requestBean.getBigDecimalValue("transMoney")); 
			po.setPayModel(requestBean.getIntegerValue("payModel")); 
			po.setSupplierNo(requestBean.getStringValue("supplierNo")); 
			po.setMerchantCode(requestBean.getStringValue("merchantCode")); 
			po.setBankCode(requestBean.getStringValue("bankCode")); 
			po.setMerchantNo(requestBean.getStringValue("merchantNo")); 
			po.setTransDetail(requestBean.getStringValue("transDetail")); 
			po.setTransStatus(requestBean.getIntegerValue("transStatus")); 
			po.setPayTime(new Date()); 
			po.setLockFlg(requestBean.getIntegerValue("lockFlg")); 
			po.setRunCount(requestBean.getIntegerValue("runCount")); 
			po.setLockTime(new Date()); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			otcOrderPaymentEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("订单支付表 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcOrderPaymentPo po = new OtcOrderPaymentPo();
			po.setPayNo(requestBean.getIntegerValue("payNo"));
			
			po.setTransNo(requestBean.getStringValue("transNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setTransMoney(requestBean.getBigDecimalValue("transMoney")); 
			po.setPayModel(requestBean.getIntegerValue("payModel")); 
			po.setSupplierNo(requestBean.getStringValue("supplierNo")); 
			po.setMerchantCode(requestBean.getStringValue("merchantCode")); 
			po.setBankCode(requestBean.getStringValue("bankCode")); 
			po.setMerchantNo(requestBean.getStringValue("merchantNo")); 
			po.setTransDetail(requestBean.getStringValue("transDetail")); 
			po.setTransStatus(requestBean.getIntegerValue("transStatus")); 
			po.setPayTime(new Date()); 
			po.setLockFlg(requestBean.getIntegerValue("lockFlg")); 
			po.setRunCount(requestBean.getIntegerValue("runCount")); 
			po.setLockTime(new Date()); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			int count = otcOrderPaymentEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单支付表 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderPaymentPo> query(ClientRequestBean requestBean) {
		try {
			OtcOrderPaymentPo po = otcOrderPaymentSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("payNo"));
			return new ClientResponesBean<OtcOrderPaymentPo>(po);
		}catch (Exception e) {
			log.error("订单支付表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderPaymentPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderPaymentVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcOrderPaymentVo vo = otcOrderPaymentSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("payNo"));
			return new ClientResponesBean<OtcOrderPaymentVo>(vo);
		}catch (Exception e) {
			log.error("订单支付表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderPaymentVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcOrderPaymentPo po = new OtcOrderPaymentPo();
			po.setPayNo(requestBean.getIntegerValue("payNo"));
			int count = otcOrderPaymentEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单支付表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcOrderPaymentPo po = new OtcOrderPaymentPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setPayNo(id);
			count += otcOrderPaymentEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单支付表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

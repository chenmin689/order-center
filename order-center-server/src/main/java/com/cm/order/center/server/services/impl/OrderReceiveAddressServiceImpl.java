package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcOrderReceiveAddressEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcOrderReceiveAddressSerMapper;
import com.cm.order.center.dao.po.OtcOrderReceiveAddressPo;
import com.cm.order.center.dao.vo.OtcOrderReceiveAddressVo;
import com.cm.order.center.server.services.OrderReceiveAddressService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   订单收货地址表  
 * @author chenmin
 */
@Service
@Slf4j
public class OrderReceiveAddressServiceImpl extends AbstractServiceImpl implements OrderReceiveAddressService {
	
	@Resource
	private OtcOrderReceiveAddressSerMapper otcOrderReceiveAddressSerMapper;
	
	@Resource
	private OtcOrderReceiveAddressEditMapper otcOrderReceiveAddressEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcOrderReceiveAddressPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			entity = this.queryPageVoList(entity, otcOrderReceiveAddressSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("订单收货地址表 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcOrderReceiveAddressPo po = new OtcOrderReceiveAddressPo();
			
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setReceiver(requestBean.getStringValue("receiver")); 
			po.setTelephone(requestBean.getStringValue("telephone")); 
			po.setProvinceCode(requestBean.getIntegerValue("provinceCode")); 
			po.setCityCode(requestBean.getIntegerValue("cityCode")); 
			po.setCountyCode(requestBean.getIntegerValue("countyCode")); 
			po.setTownCode(requestBean.getIntegerValue("townCode")); 
			po.setStreetCode(requestBean.getStringValue("streetCode")); 
			po.setDetailAddr(requestBean.getStringValue("detailAddr")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			otcOrderReceiveAddressEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("订单收货地址表 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcOrderReceiveAddressPo po = new OtcOrderReceiveAddressPo();
			po.setAddrSeq(requestBean.getIntegerValue("addrSeq"));
			
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setReceiver(requestBean.getStringValue("receiver")); 
			po.setTelephone(requestBean.getStringValue("telephone")); 
			po.setProvinceCode(requestBean.getIntegerValue("provinceCode")); 
			po.setCityCode(requestBean.getIntegerValue("cityCode")); 
			po.setCountyCode(requestBean.getIntegerValue("countyCode")); 
			po.setTownCode(requestBean.getIntegerValue("townCode")); 
			po.setStreetCode(requestBean.getStringValue("streetCode")); 
			po.setDetailAddr(requestBean.getStringValue("detailAddr")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			int count = otcOrderReceiveAddressEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单收货地址表 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderReceiveAddressPo> query(ClientRequestBean requestBean) {
		try {
			OtcOrderReceiveAddressPo po = otcOrderReceiveAddressSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("addrSeq"));
			return new ClientResponesBean<OtcOrderReceiveAddressPo>(po);
		}catch (Exception e) {
			log.error("订单收货地址表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderReceiveAddressPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderReceiveAddressVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcOrderReceiveAddressVo vo = otcOrderReceiveAddressSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("addrSeq"));
			return new ClientResponesBean<OtcOrderReceiveAddressVo>(vo);
		}catch (Exception e) {
			log.error("订单收货地址表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderReceiveAddressVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcOrderReceiveAddressPo po = new OtcOrderReceiveAddressPo();
			po.setAddrSeq(requestBean.getIntegerValue("addrSeq"));
			int count = otcOrderReceiveAddressEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单收货地址表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcOrderReceiveAddressPo po = new OtcOrderReceiveAddressPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setAddrSeq(id);
			count += otcOrderReceiveAddressEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单收货地址表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

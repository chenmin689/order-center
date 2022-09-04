package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcOrderDetailEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcOrderDetailSerMapper;
import com.cm.order.center.dao.po.OtcOrderDetailPo;
import com.cm.order.center.dao.vo.OtcOrderDetailVo;
import com.cm.order.center.server.services.OrderDetailService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   订单明细表  
 * @author chenmin
 */
@Service
@Slf4j
public class OrderDetailServiceImpl extends AbstractServiceImpl implements OrderDetailService {
	
	@Resource
	private OtcOrderDetailSerMapper otcOrderDetailSerMapper;
	
	@Resource
	private OtcOrderDetailEditMapper otcOrderDetailEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcOrderDetailPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			if(requestBean.isNotNull("childOrderNo")){
				entity.setWhere("childOrderNo",requestBean.getStringValue("childOrderNo"));
			}
			entity = this.queryPageVoList(entity, otcOrderDetailSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("订单明细表 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcOrderDetailPo po = new OtcOrderDetailPo();
			
			po.setUserId(requestBean.getIntegerValue("userId")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setSellType(requestBean.getIntegerValue("sellType")); 
			po.setGoodsName(requestBean.getStringValue("goodsName")); 
			po.setGoodsCode(requestBean.getIntegerValue("goodsCode")); 
			po.setGoodsImg(requestBean.getStringValue("goodsImg")); 
			po.setGoodsPrice(requestBean.getBigDecimalValue("goodsPrice")); 
			po.setBatchPrice(requestBean.getBigDecimalValue("batchPrice")); 
			po.setGoodsCount(requestBean.getIntegerValue("goodsCount")); 
			po.setGoodsMoney(requestBean.getBigDecimalValue("goodsMoney")); 
			po.setDiscountRate(requestBean.getBigDecimalValue("discountRate")); 
			po.setDiscountMoeny(requestBean.getBigDecimalValue("discountMoeny")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			otcOrderDetailEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("订单明细表 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcOrderDetailPo po = new OtcOrderDetailPo();
			po.setDetailSeq(requestBean.getIntegerValue("detailSeq"));
			
			po.setUserId(requestBean.getIntegerValue("userId")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setSellType(requestBean.getIntegerValue("sellType")); 
			po.setGoodsName(requestBean.getStringValue("goodsName")); 
			po.setGoodsCode(requestBean.getIntegerValue("goodsCode")); 
			po.setGoodsImg(requestBean.getStringValue("goodsImg")); 
			po.setGoodsPrice(requestBean.getBigDecimalValue("goodsPrice")); 
			po.setBatchPrice(requestBean.getBigDecimalValue("batchPrice")); 
			po.setGoodsCount(requestBean.getIntegerValue("goodsCount")); 
			po.setGoodsMoney(requestBean.getBigDecimalValue("goodsMoney")); 
			po.setDiscountRate(requestBean.getBigDecimalValue("discountRate")); 
			po.setDiscountMoeny(requestBean.getBigDecimalValue("discountMoeny")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			int count = otcOrderDetailEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单明细表 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderDetailPo> query(ClientRequestBean requestBean) {
		try {
			OtcOrderDetailPo po = otcOrderDetailSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("detailSeq"));
			return new ClientResponesBean<OtcOrderDetailPo>(po);
		}catch (Exception e) {
			log.error("订单明细表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderDetailPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcOrderDetailVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcOrderDetailVo vo = otcOrderDetailSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("detailSeq"));
			return new ClientResponesBean<OtcOrderDetailVo>(vo);
		}catch (Exception e) {
			log.error("订单明细表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcOrderDetailVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcOrderDetailPo po = new OtcOrderDetailPo();
			po.setDetailSeq(requestBean.getIntegerValue("detailSeq"));
			int count = otcOrderDetailEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单明细表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcOrderDetailPo po = new OtcOrderDetailPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setDetailSeq(id);
			count += otcOrderDetailEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("订单明细表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

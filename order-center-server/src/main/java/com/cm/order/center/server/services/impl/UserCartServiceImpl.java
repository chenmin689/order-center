package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcUserCartSerMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.dao.vo.OtcUserCartVo;
import com.cm.order.center.server.services.UserCartService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   会员购物车表  
 * @author chenmin
 */
@Service
@Slf4j
public class UserCartServiceImpl extends AbstractServiceImpl implements UserCartService {
	
	@Resource
	private OtcUserCartSerMapper otcUserCartSerMapper;
	
	@Resource
	private OtcUserCartEditMapper otcUserCartEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcUserCartPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("userId")){
				entity.setWhere("userId",requestBean.getIntegerValue("userId"));
			}
			if(requestBean.isNotNull("businessCode")){
				entity.setWhere("businessCode",requestBean.getStringValue("businessCode"));
			}
			entity = this.queryPageVoList(entity, otcUserCartSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("会员购物车表 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcUserCartPo po = new OtcUserCartPo();
			
			po.setUserId(requestBean.getIntegerValue("userId")); 
			po.setBusinessCode(requestBean.getStringValue("businessCode")); 
			po.setGoodsCode(requestBean.getIntegerValue("goodsCode")); 
			po.setGoodsName(requestBean.getStringValue("goodsName")); 
			po.setGoodsImg(requestBean.getStringValue("goodsImg")); 
			po.setBuyCounts(requestBean.getIntegerValue("buyCounts")); 
			po.setCartDate(requestBean.getIntegerValue("cartDate")); 
			po.setAdditional(requestBean.getStringValue("additional")); 
			po.setSelltype(requestBean.getIntegerValue("selltype")); 
			po.setActivityCode(requestBean.getStringValue("activityCode")); 
			po.setActivityPrice(requestBean.getBigDecimalValue("activityPrice")); 
			po.setCartStatus(requestBean.getIntegerValue("cartStatus")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			otcUserCartEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("会员购物车表 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcUserCartPo po = new OtcUserCartPo();
			po.setCartSeq(requestBean.getIntegerValue("cartSeq"));
			
			po.setUserId(requestBean.getIntegerValue("userId")); 
			po.setBusinessCode(requestBean.getStringValue("businessCode")); 
			po.setGoodsCode(requestBean.getIntegerValue("goodsCode")); 
			po.setGoodsName(requestBean.getStringValue("goodsName")); 
			po.setGoodsImg(requestBean.getStringValue("goodsImg")); 
			po.setBuyCounts(requestBean.getIntegerValue("buyCounts")); 
			po.setCartDate(requestBean.getIntegerValue("cartDate")); 
			po.setAdditional(requestBean.getStringValue("additional")); 
			po.setSelltype(requestBean.getIntegerValue("selltype")); 
			po.setActivityCode(requestBean.getStringValue("activityCode")); 
			po.setActivityPrice(requestBean.getBigDecimalValue("activityPrice")); 
			po.setCartStatus(requestBean.getIntegerValue("cartStatus")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			
			int count = otcUserCartEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("会员购物车表 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcUserCartPo> query(ClientRequestBean requestBean) {
		try {
			OtcUserCartPo po = otcUserCartSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("cartSeq"));
			return new ClientResponesBean<OtcUserCartPo>(po);
		}catch (Exception e) {
			log.error("会员购物车表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcUserCartPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcUserCartVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcUserCartVo vo = otcUserCartSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("cartSeq"));
			return new ClientResponesBean<OtcUserCartVo>(vo);
		}catch (Exception e) {
			log.error("会员购物车表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcUserCartVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcUserCartPo po = new OtcUserCartPo();
			po.setCartSeq(requestBean.getIntegerValue("cartSeq"));
			int count = otcUserCartEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("会员购物车表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcUserCartPo po = new OtcUserCartPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setCartSeq(id);
			count += otcUserCartEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("会员购物车表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcCityPostCostEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcCityPostCostSerMapper;
import com.cm.order.center.dao.po.OtcCityPostCostPo;
import com.cm.order.center.dao.vo.OtcCityPostCostVo;
import com.cm.order.center.server.services.CityPostCostService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   城市物流费用配置  
 * @author chenmin
 */
@Service
@Slf4j
public class CityPostCostServiceImpl extends AbstractServiceImpl implements CityPostCostService {
	
	@Resource
	private OtcCityPostCostSerMapper otcCityPostCostSerMapper;
	
	@Resource
	private OtcCityPostCostEditMapper otcCityPostCostEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcCityPostCostPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("businessCode")){
				entity.setWhere("businessCode",requestBean.getStringValue("businessCode"));
			}
			if(requestBean.isNotNull("provinceCode")){
				entity.setWhere("provinceCode",requestBean.getIntegerValue("provinceCode"));
			}
			entity = this.queryPageVoList(entity, otcCityPostCostSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("城市物流费用配置 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcCityPostCostPo po = new OtcCityPostCostPo();
			
			po.setBusinessCode(requestBean.getStringValue("businessCode")); 
			po.setProvinceCode(requestBean.getIntegerValue("provinceCode")); 
			po.setCityCode(requestBean.getIntegerValue("cityCode")); 
			po.setCountyCode(requestBean.getIntegerValue("countyCode")); 
			po.setCost(requestBean.getBigDecimalValue("cost")); 
			po.setConfigStatus(requestBean.getIntegerValue("configStatus")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			po.setOptName(requestBean.getIntegerValue("optName")); 
			
			otcCityPostCostEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("城市物流费用配置 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcCityPostCostPo po = new OtcCityPostCostPo();
			po.setCostSeq(requestBean.getIntegerValue("costSeq"));
			
			po.setBusinessCode(requestBean.getStringValue("businessCode")); 
			po.setProvinceCode(requestBean.getIntegerValue("provinceCode")); 
			po.setCityCode(requestBean.getIntegerValue("cityCode")); 
			po.setCountyCode(requestBean.getIntegerValue("countyCode")); 
			po.setCost(requestBean.getBigDecimalValue("cost")); 
			po.setConfigStatus(requestBean.getIntegerValue("configStatus")); 
			po.setCreateTime(new Date()); 
			po.setUpdateTime(new Date()); 
			po.setOptName(requestBean.getIntegerValue("optName")); 
			
			int count = otcCityPostCostEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("城市物流费用配置 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcCityPostCostPo> query(ClientRequestBean requestBean) {
		try {
			OtcCityPostCostPo po = otcCityPostCostSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("costSeq"));
			return new ClientResponesBean<OtcCityPostCostPo>(po);
		}catch (Exception e) {
			log.error("城市物流费用配置 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcCityPostCostPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcCityPostCostVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcCityPostCostVo vo = otcCityPostCostSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("costSeq"));
			return new ClientResponesBean<OtcCityPostCostVo>(vo);
		}catch (Exception e) {
			log.error("城市物流费用配置 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcCityPostCostVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcCityPostCostPo po = new OtcCityPostCostPo();
			po.setCostSeq(requestBean.getIntegerValue("costSeq"));
			int count = otcCityPostCostEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("城市物流费用配置 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcCityPostCostPo po = new OtcCityPostCostPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setCostSeq(id);
			count += otcCityPostCostEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("城市物流费用配置 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

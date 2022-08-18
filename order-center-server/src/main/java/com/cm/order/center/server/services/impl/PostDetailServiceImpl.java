package com.cm.order.center.server.services.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.jdbc.entity.QueryListEntity;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.architecture.jdbc.service.AbstractServiceImpl;
import com.cm.order.center.dao.mapper.edit.OtcPostDetailEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcPostDetailSerMapper;
import com.cm.order.center.dao.po.OtcPostDetailPo;
import com.cm.order.center.dao.vo.OtcPostDetailVo;
import com.cm.order.center.server.services.PostDetailService;
import com.cm.architecture.jdbc.utils.ModelErrorEnum;
import java.util.Date;
import java.util.List;

/**
 *   物流运转明细表  
 * @author chenmin
 */
@Service
@Slf4j
public class PostDetailServiceImpl extends AbstractServiceImpl implements PostDetailService {
	
	@Resource
	private OtcPostDetailSerMapper otcPostDetailSerMapper;
	
	@Resource
	private OtcPostDetailEditMapper otcPostDetailEditMapper;

	public ClientResponesBean<ResultFrontendVo> search(ClientRequestBean requestBean) {
		try {
			QueryListEntity entity = new QueryListEntity(OtcPostDetailPo.class);
			entity.setPage(requestBean.getIntegerValue("page"));
			entity.setRows(requestBean.getIntegerValue("rows"));
			if(requestBean.isNotNull("contractNo")){
				entity.setWhere("contractNo",requestBean.getStringValue("contractNo"));
			}
			if(requestBean.isNotNull("orderNo")){
				entity.setWhere("orderNo",requestBean.getStringValue("orderNo"));
			}
			if(requestBean.isNotNull("childOrderNo")){
				entity.setWhere("childOrderNo",requestBean.getStringValue("childOrderNo"));
			}
			if(requestBean.isNotNull("postNo")){
				entity.setWhere("postNo",requestBean.getStringValue("postNo"));
			}
			entity = this.queryPageVoList(entity, otcPostDetailSerMapper);
			return new ClientResponesBean<ResultFrontendVo>(entity.getResultFrontendVo());
		}catch (Exception e) {
			log.error("物流运转明细表 ,分页查询异常：",e);
			return new ClientResponesBean<ResultFrontendVo>(ModelErrorEnum._100001.getCode(),ModelErrorEnum._100001.getMsg());
		}
	}

	public ClientResponesBean<String> add(ClientRequestBean requestBean) {
		try {
			OtcPostDetailPo po = new OtcPostDetailPo();
			
			po.setContractNo(requestBean.getStringValue("contractNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setPostNo(requestBean.getStringValue("postNo")); 
			po.setPostType(requestBean.getIntegerValue("postType")); 
			po.setPostInfo(requestBean.getStringValue("postInfo")); 
			po.setCreateTime(new Date()); 
			
			otcPostDetailEditMapper.save(po);
			return new ClientResponesBean<String>();
		}catch (Exception e) {
			log.error("物流运转明细表 ,添加数据异常：",e);
			return new ClientResponesBean<String>(ModelErrorEnum._100002.getCode(),ModelErrorEnum._100002.getMsg());
		}
	}

	public ClientResponesBean<Integer> edit(ClientRequestBean requestBean) {
		try {
			OtcPostDetailPo po = new OtcPostDetailPo();
			po.setPostSeq(requestBean.getIntegerValue("postSeq"));
			
			po.setContractNo(requestBean.getStringValue("contractNo")); 
			po.setOrderNo(requestBean.getStringValue("orderNo")); 
			po.setChildOrderNo(requestBean.getStringValue("childOrderNo")); 
			po.setPostNo(requestBean.getStringValue("postNo")); 
			po.setPostType(requestBean.getIntegerValue("postType")); 
			po.setPostInfo(requestBean.getStringValue("postInfo")); 
			po.setCreateTime(new Date()); 
			
			int count = otcPostDetailEditMapper.editEntity(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("物流运转明细表 ,修改数据异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100003.getCode(),ModelErrorEnum._100003.getMsg());
		}
	}

	public ClientResponesBean<OtcPostDetailPo> query(ClientRequestBean requestBean) {
		try {
			OtcPostDetailPo po = otcPostDetailSerMapper.byPrimaryKeyPo(requestBean.getIntegerValue("postSeq"));
			return new ClientResponesBean<OtcPostDetailPo>(po);
		}catch (Exception e) {
			log.error("物流运转明细表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcPostDetailPo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<OtcPostDetailVo> queryVo(ClientRequestBean requestBean) {
		try {
			OtcPostDetailVo vo = otcPostDetailSerMapper.byPrimaryKeyVo(requestBean.getIntegerValue("postSeq"));
			return new ClientResponesBean<OtcPostDetailVo>(vo);
		}catch (Exception e) {
			log.error("物流运转明细表 ,单条数据查询异常：",e);
			return new ClientResponesBean<OtcPostDetailVo>(ModelErrorEnum._100004.getCode(),ModelErrorEnum._100004.getMsg());
		}
	}

	public ClientResponesBean<Integer> del(ClientRequestBean requestBean) {
		try {
			OtcPostDetailPo po = new OtcPostDetailPo();
			po.setPostSeq(requestBean.getIntegerValue("postSeq"));
			int count = otcPostDetailEditMapper.remove(po);
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("物流运转明细表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}
	public ClientResponesBean<Integer> batchDel(ClientRequestBean requestBean) {
		try {
			OtcPostDetailPo po = new OtcPostDetailPo();
			List<Integer> list = requestBean.getListInteger("batchId");
			int count = 0;
			for(Integer id : list){
			po.setPostSeq(id);
			count += otcPostDetailEditMapper.remove(po);
			}
			return new ClientResponesBean<Integer>(count);
		}catch (Exception e) {
			log.error("物流运转明细表 ,单条数据删除异常：",e);
			return new ClientResponesBean<Integer>(ModelErrorEnum._100005.getCode(),ModelErrorEnum._100005.getMsg());
		}
	}

}

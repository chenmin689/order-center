package com.cm.order.center.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.dao.po.OtcPostCompanyCostPo;
import com.cm.order.center.dao.vo.OtcPostCompanyCostVo;
import com.cm.order.center.server.services.PostCompanyCostService;

/**
 * 物流公司增值费用--控制器
 * @author chenmin
 */
@RestController
@RequestMapping("order")
@Api(tags = "物流公司增值费用")
public class PostCompanyCostController{
	
	@Autowired
	private PostCompanyCostService postCompanyCostService;

	/**
	 * 分页集合查询
	 * @param clientRequestBean
	 * @return ClientResponesBean<ResultFrontendVo>
	 */
	@RequestMapping(path="/postcompanycost/search",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--分页集合查询")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<ResultFrontendVo> search(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.search(clientRequestBean);
	}

	/**
	 * 添加信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<String>
	 */
	@RequestMapping(path="/postcompanycost/add",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--添加信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<String> add(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.add(clientRequestBean);
	}

	/**
	 * 修改信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/postcompanycost/edit",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--修改信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> edit(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.edit(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/postcompanycost/query",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcPostCompanyCostPo> query(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.query(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/postcompanycost/queryVo",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcPostCompanyCostVo> queryVo(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.queryVo(clientRequestBean);
	}

	/**
	 * 根据主键删除信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/postcompanycost/del",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> del(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.del(clientRequestBean);
	}
	@RequestMapping(path="/postcompanycost/batchDel",method=RequestMethod.POST)
	@ApiOperation("物流公司增值费用--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> batchDel(@RequestBody ClientRequestBean clientRequestBean) {
		
		return postCompanyCostService.batchDel(clientRequestBean);
	}

}

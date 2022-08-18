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
import com.cm.order.center.dao.po.OtcOrderContractPo;
import com.cm.order.center.dao.vo.OtcOrderContractVo;
import com.cm.order.center.server.services.OrderContractService;

/**
 * 订单履约表--控制器
 * @author chenmin
 */
@RestController
@RequestMapping("order")
@Api(tags = "订单履约表")
public class OrderContractController{
	
	@Autowired
	private OrderContractService orderContractService;

	/**
	 * 分页集合查询
	 * @param clientRequestBean
	 * @return ClientResponesBean<ResultFrontendVo>
	 */
	@RequestMapping(path="/ordercontract/search",method=RequestMethod.POST)
	@ApiOperation("订单履约表--分页集合查询")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<ResultFrontendVo> search(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.search(clientRequestBean);
	}

	/**
	 * 添加信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<String>
	 */
	@RequestMapping(path="/ordercontract/add",method=RequestMethod.POST)
	@ApiOperation("订单履约表--添加信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<String> add(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.add(clientRequestBean);
	}

	/**
	 * 修改信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/ordercontract/edit",method=RequestMethod.POST)
	@ApiOperation("订单履约表--修改信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> edit(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.edit(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/ordercontract/query",method=RequestMethod.POST)
	@ApiOperation("订单履约表--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcOrderContractPo> query(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.query(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/ordercontract/queryVo",method=RequestMethod.POST)
	@ApiOperation("订单履约表--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcOrderContractVo> queryVo(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.queryVo(clientRequestBean);
	}

	/**
	 * 根据主键删除信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/ordercontract/del",method=RequestMethod.POST)
	@ApiOperation("订单履约表--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> del(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.del(clientRequestBean);
	}
	@RequestMapping(path="/ordercontract/batchDel",method=RequestMethod.POST)
	@ApiOperation("订单履约表--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> batchDel(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderContractService.batchDel(clientRequestBean);
	}

}

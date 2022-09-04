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
import com.cm.order.center.dao.po.OtcOrderReceiveAddressPo;
import com.cm.order.center.dao.vo.OtcOrderReceiveAddressVo;
import com.cm.order.center.server.services.OrderReceiveAddressService;

/**
 * 订单收货地址表--控制器
 * @author chenmin
 */
@RestController
@RequestMapping("order")
@Api(tags = "订单收货地址表")
public class OrderReceiveAddressController{
	
	@Autowired
	private OrderReceiveAddressService orderReceiveAddressService;

	/**
	 * 分页集合查询
	 * @param clientRequestBean
	 * @return ClientResponesBean<ResultFrontendVo>
	 */
	@RequestMapping(path="/orderreceiveaddress/search",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--分页集合查询")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<ResultFrontendVo> search(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.search(clientRequestBean);
	}

	/**
	 * 添加信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<String>
	 */
	@RequestMapping(path="/orderreceiveaddress/add",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--添加信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<String> add(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.add(clientRequestBean);
	}

	/**
	 * 修改信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/orderreceiveaddress/edit",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--修改信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> edit(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.edit(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/orderreceiveaddress/query",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcOrderReceiveAddressPo> query(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.query(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/orderreceiveaddress/queryVo",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcOrderReceiveAddressVo> queryVo(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.queryVo(clientRequestBean);
	}

	/**
	 * 根据主键删除信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/orderreceiveaddress/del",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> del(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.del(clientRequestBean);
	}
	@RequestMapping(path="/orderreceiveaddress/batchDel",method=RequestMethod.POST)
	@ApiOperation("订单收货地址表--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> batchDel(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderReceiveAddressService.batchDel(clientRequestBean);
	}

}

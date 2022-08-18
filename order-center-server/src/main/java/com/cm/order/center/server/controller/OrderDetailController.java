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
import com.cm.order.center.dao.po.OtcOrderDetailPo;
import com.cm.order.center.dao.vo.OtcOrderDetailVo;
import com.cm.order.center.server.services.OrderDetailService;

/**
 * 订单明细表--控制器
 * @author chenmin
 */
@RestController
@RequestMapping("order")
@Api(tags = "订单明细表")
public class OrderDetailController{
	
	@Autowired
	private OrderDetailService orderDetailService;

	/**
	 * 分页集合查询
	 * @param clientRequestBean
	 * @return ClientResponesBean<ResultFrontendVo>
	 */
	@RequestMapping(path="/orderdetail/search",method=RequestMethod.POST)
	@ApiOperation("订单明细表--分页集合查询")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<ResultFrontendVo> search(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.search(clientRequestBean);
	}

	/**
	 * 添加信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<String>
	 */
	@RequestMapping(path="/orderdetail/add",method=RequestMethod.POST)
	@ApiOperation("订单明细表--添加信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<String> add(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.add(clientRequestBean);
	}

	/**
	 * 修改信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/orderdetail/edit",method=RequestMethod.POST)
	@ApiOperation("订单明细表--修改信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> edit(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.edit(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/orderdetail/query",method=RequestMethod.POST)
	@ApiOperation("订单明细表--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcOrderDetailPo> query(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.query(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/orderdetail/queryVo",method=RequestMethod.POST)
	@ApiOperation("订单明细表--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcOrderDetailVo> queryVo(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.queryVo(clientRequestBean);
	}

	/**
	 * 根据主键删除信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/orderdetail/del",method=RequestMethod.POST)
	@ApiOperation("订单明细表--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> del(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.del(clientRequestBean);
	}
	@RequestMapping(path="/orderdetail/batchDel",method=RequestMethod.POST)
	@ApiOperation("订单明细表--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> batchDel(@RequestBody ClientRequestBean clientRequestBean) {
		
		return orderDetailService.batchDel(clientRequestBean);
	}

}

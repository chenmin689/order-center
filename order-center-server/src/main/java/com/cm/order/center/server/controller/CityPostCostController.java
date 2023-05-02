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
import com.cm.order.center.dao.po.OtcCityPostCostPo;
import com.cm.order.center.dao.vo.OtcCityPostCostVo;
import com.cm.order.center.server.services.CityPostCostService;

/**
 * 城市物流费用配置--控制器
 * @author chenmin
 */
@RestController
@RequestMapping("order")
@Api(tags = "城市物流费用配置")
public class CityPostCostController{
	
	@Autowired
	private CityPostCostService cityPostCostService;

	/**
	 * 分页集合查询
	 * @param clientRequestBean
	 * @return ClientResponesBean<ResultFrontendVo>
	 */
	@RequestMapping(path="/citypostcost/search",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--分页集合查询")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<ResultFrontendVo> search(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.search(clientRequestBean);
	}

	/**
	 * 添加信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<String>
	 */
	@RequestMapping(path="/citypostcost/add",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--添加信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<String> add(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.add(clientRequestBean);
	}

	/**
	 * 修改信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/citypostcost/edit",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--修改信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> edit(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.edit(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/citypostcost/query",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcCityPostCostPo> query(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.query(clientRequestBean);
	}

	/**
	 * 根据主键查询信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<TucUserAccountPo>
	 */
	@RequestMapping(path="/citypostcost/queryVo",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--根据主键查询信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<OtcCityPostCostVo> queryVo(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.queryVo(clientRequestBean);
	}

	/**
	 * 根据主键删除信息
	 * @param clientRequestBean
	 * @return ClientResponesBean<Integer>
	 */
	@RequestMapping(path="/citypostcost/del",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> del(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.del(clientRequestBean);
	}
	@RequestMapping(path="/citypostcost/batchDel",method=RequestMethod.POST)
	@ApiOperation("城市物流费用配置--根据主键删除信息")
	@ApiImplicitParam(name = "clientRequestBean", value = "请求参数", dataType = "ClientRequestBean")
	public ClientResponesBean<Integer> batchDel(@RequestBody ClientRequestBean clientRequestBean) {
		
		return cityPostCostService.batchDel(clientRequestBean);
	}

}

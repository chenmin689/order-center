package com.cm.order.center.server.nacos;

import com.cm.architecture.commons.rpc.RpcRequestBean;
import com.cm.architecture.commons.rpc.RpcResponesBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="user-center-server")
public interface UsercenterClients {


    //@RequestMapping(path="/user/query/level",method= RequestMethod.POST)
    public RpcResponesBean<String> queryUserDiscountLevel(RpcRequestBean rpcRequestBean);
}

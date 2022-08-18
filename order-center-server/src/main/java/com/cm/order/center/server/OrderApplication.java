package com.cm.order.center.server;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.cm.order.center.dao.mapper.edit","com.cm.order.center.dao.mapper.ser"})
public class OrderApplication {

    private static final Logger logger = LoggerFactory.getLogger("OrderApplication");

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
        logger.info("OrderApplication run success!");
    }
}

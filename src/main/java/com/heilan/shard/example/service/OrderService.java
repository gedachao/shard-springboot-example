package com.heilan.shard.example.service;

import com.heilan.shard.example.domain.Order;

import java.util.List;

/**
 * @Description: OrderService
 * @Author: gedachao
 * @Date: 2021-02-07 17:03
 * @Version 1.0
 */
public interface OrderService {
    int batchInsert(List<Order> orderList);

}

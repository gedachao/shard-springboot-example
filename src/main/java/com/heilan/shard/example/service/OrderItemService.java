package com.heilan.shard.example.service;

import com.heilan.shard.example.domain.OrderItem;

import java.util.List;

/**
 * @Description: OrderItem
 * @Author: gedachao
 * @Date: 2021-02-07 17:06
 * @Version 1.0
 */
public interface OrderItemService {
    int batchInsert(List<OrderItem> orderItemList);
}

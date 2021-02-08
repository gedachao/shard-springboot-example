package com.heilan.shard.example.service.impl;

import com.heilan.shard.example.domain.Order;
import com.heilan.shard.example.mapper.OrderMapper;
import com.heilan.shard.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: OrderServerImpl
 * @Author: gedachao
 * @Date: 2021-02-07 17:04
 * @Version 1.0
 */
@Service
public class OrderServerImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int batchInsert(List<Order> orderList) {
        int count = 0;
        for (Order order : orderList) {
            orderMapper.insert(order);
            count++;
        }
        return count;
    }

}

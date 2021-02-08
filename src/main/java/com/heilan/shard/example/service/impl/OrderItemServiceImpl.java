package com.heilan.shard.example.service.impl;

import com.heilan.shard.example.domain.OrderItem;
import com.heilan.shard.example.mapper.OrderItemMapper;
import com.heilan.shard.example.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: OrderItemServiceImpl
 * @Author: gedachao
 * @Date: 2021-02-07 17:07
 * @Version 1.0
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int batchInsert(List<OrderItem> orderItemList) {
        int count = 0;
        for (OrderItem orderItem : orderItemList) {
            orderItemMapper.insert(orderItem);
            count++;
        }
        return count;
    }
}

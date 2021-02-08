package com.heilan.shard.example;

import com.heilan.shard.example.domain.Order;
import com.heilan.shard.example.domain.OrderExample;
import com.heilan.shard.example.domain.OrderItem;
import com.heilan.shard.example.mapper.OrderMapper;
import com.heilan.shard.example.service.OrderService;
import com.heilan.shard.example.service.impl.OrderItemServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description: OrderTest
 * @Author: gedachao
 * @Date: 2021-02-07 16:57
 * @Version 1.0
 */
@SpringBootTest
@MapperScan(basePackages = "com.heilan.shard.example.mapper")
@Slf4j
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * t_order、t_order_item 分库分表
     * 1. t_order 分库策略为 com.heilan.shard.strategy.HashModShardingAlgorithm (根据 user_id hash取模)；
     *    分表策略为 com.heilan.shard.example.conf.PreciseTableShard (根据 order_id 范围)；
     * 2. t_order_item 是 t_order 的子表，所以分库分表策略必须与 t_order 相同
     */

    @Test
    void insertTest() {
        List<Order> orderList = new ArrayList<>();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            String userId = UUID.randomUUID().toString().replace("-", "");
            Order order = new Order(Integer.toUnsignedLong(i), "name" + i, userId);
            OrderItem orderItem = new OrderItem(Integer.toUnsignedLong(i), userId, order.getOrderId());
            orderList.add(order);
            orderItemList.add(orderItem);
        }
        int orderCount = orderService.batchInsert(orderList);
        int orderItemCount = orderItemService.batchInsert(orderItemList);
        log.info("插入的order记录数：{}", orderCount);
        log.info("插入的order_item记录数：{}", orderItemCount);

    }

    /**
     * 范围查询测试，需要配置 rangeAlgorithmClassName
     */
    @Test
    void rangeQueryTest() {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdBetween(2L, 7L);
        List<Order> orders = orderMapper.selectByExample(example);
        System.out.println(orders);
        log.info("数量为：{}", orders.size());
    }

}

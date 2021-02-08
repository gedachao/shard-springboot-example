package com.heilan.shard.example.domain;

public class OrderItem {
    private Long orderItemId;

    private String userId;

    private Long orderId;

    public OrderItem() {
    }

    public OrderItem(Long orderItemId, String userId, Long orderId) {
        this.orderItemId = orderItemId;
        this.userId = userId;
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", userId='" + userId + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
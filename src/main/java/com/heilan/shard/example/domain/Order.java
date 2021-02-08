package com.heilan.shard.example.domain;

public class Order {
    private Long orderId;

    private String name;

    private String userId;

    public Order() {
    }

    public Order(Long orderId, String name, String userId) {
        this.orderId = orderId;
        this.name = name;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
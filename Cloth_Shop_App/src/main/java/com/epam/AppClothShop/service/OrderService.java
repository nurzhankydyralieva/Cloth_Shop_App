package com.epam.AppClothShop.service;

import com.epam.AppClothShop.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order createOrder(Order order);

    Order getOrderById(Long id);

    void deleteOrderById(Long id);

    Order updateOrder(Order order, Long id);

}

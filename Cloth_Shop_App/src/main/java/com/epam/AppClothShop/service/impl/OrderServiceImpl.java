package com.epam.AppClothShop.service.impl;

import com.epam.AppClothShop.model.Order;
import com.epam.AppClothShop.repository.OrderRepository;
import com.epam.AppClothShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;


    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        throw new RuntimeException("Order with id " + id + " not found");

    }

    @Override
    @Transactional
    public void deleteOrderById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Order updateOrder(Order updatedOrder, Long id) {
        updatedOrder.setId(id);
        return repository.save(updatedOrder);
    }
}


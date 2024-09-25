package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dto.requestTo.OrderRequestTO;
import com.pavcore.plumbing.dto.responseTo.OrderResponseTO;
import com.pavcore.plumbing.dao.postgres.entity.Order;
import com.pavcore.plumbing.mapper.OrderMapper;
import com.pavcore.plumbing.dao.postgres.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepo orderRepo, OrderMapper orderMapper) {
        this.orderRepo = orderRepo;
        this.orderMapper = orderMapper;
    }

    public List<OrderResponseTO> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        List<OrderResponseTO> orderResponseTOs = new ArrayList<>();
        for (Order order : orders) {
            orderResponseTOs.add(orderMapper.mapResp(order));
        }
        return orderResponseTOs;
    }

    public OrderResponseTO getOrderById(long id) {
        return orderMapper.mapResp(orderRepo.getReferenceById(id));
    }

    public OrderResponseTO createOrder(OrderRequestTO orderRequestTO) {
        Order order = orderMapper.mapReq(orderRequestTO);
        orderRepo.save(order);
        return orderMapper.mapResp(order);
    }

    public void deleteOrderById(long id) {
        orderRepo.deleteById(id);
    }
}

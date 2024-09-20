package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dto.responseTo.OrderProductResponseTO;
import com.pavcore.plumbing.entiy.Order;
import com.pavcore.plumbing.entiy.OrderProduct;
import com.pavcore.plumbing.entiy.Product;
import com.pavcore.plumbing.mapper.OrderProductMapper;
import com.pavcore.plumbing.repo.OrderProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    private final OrderProductRepo orderProductRepo;
    private final OrderProductMapper orderProductMapper;

    @Autowired
    public OrderProductService(OrderProductRepo orderProductRepo, OrderProductMapper orderProductMapper) {
        this.orderProductRepo = orderProductRepo;
        this.orderProductMapper = orderProductMapper;
    }

    public OrderProductResponseTO getOrderProductById(long id) {
        OrderProduct orderProduct = orderProductRepo.getReferenceById(id);
        return orderProductMapper.mapResp(orderProduct);
    }

    public OrderProductResponseTO createOrderProduct(Order order, Product product, int quantity) {
        OrderProduct orderProduct = OrderProduct.builder()
                .order(order)
                .productId(product.getId())
                .quantity(quantity)
                .build();
        orderProductRepo.save(orderProduct);
        return orderProductMapper.mapResp(orderProduct);
    }

    public void deleteOrderProductById(long id) {
        orderProductRepo.deleteById(id);
    }
}

package com.pavcore.plumbing.mapper;

import com.pavcore.plumbing.dto.requestTo.OrderRequestTO;
import com.pavcore.plumbing.dto.responseTo.OrderResponseTO;
import com.pavcore.plumbing.entiy.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order mapReq(OrderRequestTO orderRequestTO);

    OrderRequestTO mapReq(Order order);

    Order mapResp(OrderResponseTO orderResponseTO);

    OrderResponseTO mapResp(Order order);

}

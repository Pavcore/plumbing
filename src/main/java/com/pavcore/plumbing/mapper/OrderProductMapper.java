package com.pavcore.plumbing.mapper;

import com.pavcore.plumbing.dto.responseTo.OrderProductResponseTO;
import com.pavcore.plumbing.dao.postgres.entity.OrderProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {

    OrderProduct mapResp(OrderProductResponseTO orderProductResponseTO);
    OrderProductResponseTO mapResp(OrderProduct orderProduct);

}

package com.pavcore.plumbing.dto.responseTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResponseTO {

    private long orderId;
    private long userId;
    private Set<OrderProductResponseTO> orderProductsResponseTOs;

}

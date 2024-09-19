package com.pavcore.plumbing.dto.requestTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestTO {

    private String title;
    private double price;
    private double weight;
    private String material;
    private String color;
    private long articleNumber;
    private String description;

}

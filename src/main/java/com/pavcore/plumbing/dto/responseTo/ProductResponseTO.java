package com.pavcore.plumbing.dto.responseTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponseTO {

    private long id;
    private String title;
    private double price;
    private double weight;
    private String material;
    private String color;
    private long articleNumber;
    private String description;

}

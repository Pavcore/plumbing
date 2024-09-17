package com.pavcore.plumbing.entiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "weight")
    private double weight;

    @Column(name = "material", length = 64)
    private String material;

    @Column(name = "color", length = 64)
    private String color;

    @Column(name = "article_number")
    private int articleNumber;

    @Column(name = "description", length = 2048)
    private String description;
}

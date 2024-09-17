package com.pavcore.plumbing.repo;

import com.pavcore.plumbing.entiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}

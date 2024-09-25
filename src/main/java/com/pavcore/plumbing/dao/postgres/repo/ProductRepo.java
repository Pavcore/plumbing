package com.pavcore.plumbing.dao.postgres.repo;

import com.pavcore.plumbing.dao.postgres.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}

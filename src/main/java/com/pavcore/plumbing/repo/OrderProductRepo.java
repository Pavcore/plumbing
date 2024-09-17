package com.pavcore.plumbing.repo;

import com.pavcore.plumbing.entiy.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}

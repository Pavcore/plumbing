package com.pavcore.plumbing.dao.postgres.repo;

import com.pavcore.plumbing.dao.postgres.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}

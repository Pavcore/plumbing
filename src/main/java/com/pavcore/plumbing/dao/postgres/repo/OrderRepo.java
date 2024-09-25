package com.pavcore.plumbing.dao.postgres.repo;

import com.pavcore.plumbing.dao.postgres.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}

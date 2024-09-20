package com.pavcore.plumbing.repo;

import com.pavcore.plumbing.entiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}

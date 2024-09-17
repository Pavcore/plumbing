package com.pavcore.plumbing.repo;

import com.pavcore.plumbing.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}

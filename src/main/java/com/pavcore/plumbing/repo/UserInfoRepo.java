package com.pavcore.plumbing.repo;

import com.pavcore.plumbing.entiy.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
}

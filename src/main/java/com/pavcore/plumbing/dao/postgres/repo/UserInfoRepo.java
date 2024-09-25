package com.pavcore.plumbing.dao.postgres.repo;

import com.pavcore.plumbing.dao.postgres.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
}

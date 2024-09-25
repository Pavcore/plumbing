package com.pavcore.plumbing.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.pavcore.plumbing.dao.postgres.repo")
@EntityScan(basePackages = "com.pavcore.plumbing.dao.postgres.entity")
public class PostgresConfig {
}

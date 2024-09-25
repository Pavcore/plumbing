package com.pavcore.plumbing.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.pavcore.plumbing.dao.mongo.repo")
@EntityScan(basePackages = "com.pavcore.plumbing.dao.mongo.entity")
public class MongoConfig {
}

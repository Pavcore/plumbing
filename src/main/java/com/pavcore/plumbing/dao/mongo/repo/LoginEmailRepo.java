package com.pavcore.plumbing.dao.mongo.repo;

import com.pavcore.plumbing.dao.mongo.entity.LoginEmail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginEmailRepo extends MongoRepository<LoginEmail, Long> {
    LoginEmail findByEmail(String email);
    LoginEmail findByLogin(String login);
}

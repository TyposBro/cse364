package me.typosbro.moshimoshi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Number>{
    
}

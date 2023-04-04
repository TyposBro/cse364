package me.typosbro.moshimoshi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, Number>{
    
}

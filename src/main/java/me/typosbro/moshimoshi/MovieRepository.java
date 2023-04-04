package me.typosbro.moshimoshi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository  extends MongoRepository<Movie, Number>{
    
}

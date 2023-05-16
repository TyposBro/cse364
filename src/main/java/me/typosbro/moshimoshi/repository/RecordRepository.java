package me.typosbro.moshimoshi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.typosbro.moshimoshi.collection.Record;;

public interface RecordRepository extends MongoRepository<Record, String> {

}

package me.typosbro.moshimoshi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import me.typosbro.moshimoshi.collection.Record;
import me.typosbro.moshimoshi.repository.RecordRepository;

@Service
public class RecordServiceImplementation implements RecordService {
    @Autowired
    RecordRepository recordRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Record> getAll() {
        return recordRepository.findAll();
    };
}

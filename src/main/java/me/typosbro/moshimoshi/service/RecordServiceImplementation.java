package me.typosbro.moshimoshi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import me.typosbro.moshimoshi.collection.Record;
import me.typosbro.moshimoshi.collection.Timestamp;
import me.typosbro.moshimoshi.repository.RecordRepository;

@Service
public class RecordServiceImplementation implements RecordService {
    @Autowired
    RecordRepository recordRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Record> get() {
        return recordRepository.findAll();
    }

    @Override
    public String save(Record record) {
        return recordRepository.save(record).getRecordId();
    }

    @Override
    public String delete(String id) {
        recordRepository.deleteById(id);
        return id;
    }

    @Override
    public String deleteTimestamp(String id, String timestampId) {
        Record record = recordRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
        List<Timestamp> timestamps = record.getTimestamp();
        timestamps.removeIf(timestamp -> timestamp.getTimestampId().equals(timestampId));
        recordRepository.save(record);
        return "Deleted timestamp with id: " + timestampId + " from record with id: " + id + ".";
    };
}

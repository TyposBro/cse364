package me.typosbro.moshimoshi.service;

import java.util.List;

import me.typosbro.moshimoshi.collection.Record;
import me.typosbro.moshimoshi.collection.Timestamp;

public interface RecordService {

    List<Record> get();

    String save(Record record);

    String delete(String id);

    String deleteTimestamp(String id, String timestampId);

    Record update(String id, Record record);

    Record getById(String id);

    Record updateTimestamp(String id, String timestampId, Timestamp timestamp);
}

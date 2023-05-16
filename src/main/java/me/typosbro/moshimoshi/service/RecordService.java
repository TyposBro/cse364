package me.typosbro.moshimoshi.service;

import java.util.List;

import me.typosbro.moshimoshi.collection.Record;

public interface RecordService {

    List<Record> get();

    String save(Record record);

    String delete(String id);

    String deleteTimestamp(String id, String timestampId);
}

package me.typosbro.moshimoshi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import me.typosbro.moshimoshi.collection.Record;
import me.typosbro.moshimoshi.service.RecordService;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @GetMapping
    public List<Record> get() {
        return recordService.get();
    }

    @PostMapping
    public String save(@RequestBody Record record) {
        return recordService.save(record);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return recordService.delete(id);
    }

    @DeleteMapping("/{id}/{timestampId}")
    public String deleteTimestamp(@PathVariable String id, @PathVariable String timestampId) {
        return recordService.deleteTimestamp(id, timestampId);
    }

}

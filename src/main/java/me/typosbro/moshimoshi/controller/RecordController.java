package me.typosbro.moshimoshi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Record> getAll() {
        return recordService.getAll();
    }

    @PostMapping
    public String save(@RequestBody Record record) {
        return recordService.save(record);
    }

}

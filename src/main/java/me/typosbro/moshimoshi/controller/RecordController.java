package me.typosbro.moshimoshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.typosbro.moshimoshi.service.RecordService;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

}

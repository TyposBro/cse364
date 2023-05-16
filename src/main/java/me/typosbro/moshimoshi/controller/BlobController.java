package me.typosbro.moshimoshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.typosbro.moshimoshi.service.BlobService;

@RestController
@RequestMapping("/blob")
public class BlobController {
    @Autowired
    BlobService blobService;
}

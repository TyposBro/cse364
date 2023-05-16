package me.typosbro.moshimoshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.typosbro.moshimoshi.service.BlobService;

@RestController
@RequestMapping("/blob")
public class BlobController {
    @Autowired
    BlobService blobService;

    @PostMapping
    public String upload(@RequestParam("blob") MultipartFile file) {
        return blobService.upload(file);
    }
}

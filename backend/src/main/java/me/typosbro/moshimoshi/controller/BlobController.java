package me.typosbro.moshimoshi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.typosbro.moshimoshi.collection.Blob;
import me.typosbro.moshimoshi.service.BlobService;

@RestController
@RequestMapping("/blob")
public class BlobController {
    @Autowired
    BlobService blobService;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> get(@PathVariable String id) {
        Blob blob = blobService.get(id);
        Resource resource = new ByteArrayResource(blob.getContent().getData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + blob.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(blob.getContent().length()).body(resource);
    }

    @PostMapping
    public String upload(@RequestBody("blob") MultipartFile file) throws IOException {
        return blobService.upload(file.getOriginalFilename(), file);
    }

}

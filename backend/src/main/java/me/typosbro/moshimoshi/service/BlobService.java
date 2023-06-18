package me.typosbro.moshimoshi.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import me.typosbro.moshimoshi.collection.Blob;

public interface BlobService {

    String upload(String title, MultipartFile file) throws IOException;

    Blob get(String id);

}

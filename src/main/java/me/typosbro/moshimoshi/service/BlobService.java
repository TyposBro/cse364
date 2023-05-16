package me.typosbro.moshimoshi.service;

import org.springframework.web.multipart.MultipartFile;

public interface BlobService {

    String upload(MultipartFile file);

}

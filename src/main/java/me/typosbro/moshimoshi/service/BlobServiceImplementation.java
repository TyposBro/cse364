package me.typosbro.moshimoshi.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.typosbro.moshimoshi.collection.Blob;
import me.typosbro.moshimoshi.repository.BlobRepository;

@Service
public class BlobServiceImplementation implements BlobService {
    @Autowired
    BlobRepository blobRepository;

    @Override
    public String upload(String title, MultipartFile file) throws IOException {
        Blob blob = new Blob();
        blob.setTitle(title);
        blob.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        return blobRepository.save(blob).getId();
    }

    @Override
    public Blob get(String id) {
        return blobRepository.findById(id).get();

    }

}

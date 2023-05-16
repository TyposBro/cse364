package me.typosbro.moshimoshi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import me.typosbro.moshimoshi.collection.Blob;

@Repository
public interface BlobRepository extends MongoRepository<Blob, String> {

    String upload(MultipartFile file);

}

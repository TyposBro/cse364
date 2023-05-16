package me.typosbro.moshimoshi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.typosbro.moshimoshi.repository.BlobRepository;

@Service
public class BlobServiceImplementation implements BlobService {
    @Autowired
    BlobRepository blobRepository;
}

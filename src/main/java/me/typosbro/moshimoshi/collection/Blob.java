package me.typosbro.moshimoshi.collection;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "blob")
public class Blob {
    @Id
    private String id;
    private String title;
    private Binary content;
}

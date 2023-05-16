package me.typosbro.moshimoshi.collection;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@Builder
@Document(collection = "record")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Record {
    @Id
    private String recordId;
    private List<Timestamp> timestamp;
    // recording url

    // TODO: Binary upload/download url
}

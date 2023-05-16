package me.typosbro.moshimoshi.collection;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "record")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Record {
    @Id
    private String recordId;
    private List<Timestamp> timestamp;
    private Date date;
    private String url;
}

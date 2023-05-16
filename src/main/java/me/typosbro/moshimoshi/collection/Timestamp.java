package me.typosbro.moshimoshi.collection;

import lombok.Builder;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@Builder
public class Timestamp {
    @Id
    private String timestampId;
    private String tag;
    private String start;
    private String end;

}

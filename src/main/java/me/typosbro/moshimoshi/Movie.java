package me.typosbro.moshimoshi;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class Movie {
    @Id
    private Number id;
    private String title;
    private List<String> genre;

    public Movie(String title, List<String>genre){
        this.title = title;
        this.genre = genre;
    }
}

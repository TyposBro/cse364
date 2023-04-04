package me.typosbro.moshimoshi;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private List<String> genre;

    public Movie(String title, List<String>genre){
        this.title = title;
        this.genre = genre;
    }
}

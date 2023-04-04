package me.typosbro.moshimoshi;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private User user;
    private Movie movie;
    private Number rating;
    private Number timestamp;

    public Rating(User user, Movie movie, Number rating, Number timestamp) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.timestamp = timestamp;
    }
}

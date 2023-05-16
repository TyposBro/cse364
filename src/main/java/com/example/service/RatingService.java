package com.example.service;

import java.util.List;

import com.example.model.Rating;
import com.example.model.Result;

public interface RatingService {

    String save(Rating rating);

    Result<List<Object>> getMovieRatingGTE(double rating);

}

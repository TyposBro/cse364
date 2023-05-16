package com.example.service;

import com.example.model.Movie;

public interface MovieService {

    public Movie getMovieById(int id);

    public long count();
}

package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Rating;
import com.example.model.Result;
import com.example.repositories.RatingRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ReplaceRootOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;

@Service
public class RatingServiceImpl implements RatingService{
    
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Rating rating){
        return ratingRepository.save(rating).getId();
    }

    @Override
    public Result<List<Object>> getMovieRatingGTE(double rating){
        if(rating < 1 || rating > 5) {
            return new Result<List<Object>>(false);
        }

        // Efficiently calculate the average rating of each movie
        GroupOperation avgRating = Aggregation.group("$movie_id")
                                            .avg("$rating").
                                            as("avg_rating");

        // Create a Matching criteria for each movie, where the average rating should be >= the threshold.
        MatchOperation filterRating = Aggregation.match(
            Criteria.where("avg_rating").gte(rating)
        );

        // Sort the movies by their ID
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.ASC, "movie_id");

        // Assign the movie ID to their information from the movie collection
        LookupOperation movieLookup = Aggregation.lookup("movie", "_id", "movie_id", "matching_movie");

        // Unwind the movie information, i.e., remove the unnecessary brackets
        UnwindOperation unwindMovie = Aggregation.unwind("$matching_movie");

        // Make the matching movies as root
        ReplaceRootOperation replaceRoot = Aggregation.replaceRoot("$matching_movie");

        // Only consider movie names and their genres
        ProjectionOperation projectMovie = Aggregation.project("movie_name", "genre")
                                                      .andExclude("_id");
        // Finalize the query
        Aggregation aggregation = Aggregation.newAggregation(
            avgRating,
            filterRating,
            sortOperation,
            movieLookup,
            unwindMovie,
            replaceRoot,
            projectMovie
        );

        AggregationResults<Object> results = mongoTemplate.aggregate(
            aggregation, 
            "rating", 
            Object.class
        );

        // Return the results
        return new Result<List<Object>>(true, results.getMappedResults());
    }
}

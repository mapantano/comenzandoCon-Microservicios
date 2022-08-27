package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findByGenre(String genre){
        return this.movieRepository.findByGenre(genre);
    }

}

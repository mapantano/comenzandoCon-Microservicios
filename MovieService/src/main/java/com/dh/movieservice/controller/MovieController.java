package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${server.port}")
    private String port;
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> findByGenre(@PathVariable("genre") String genre){
    List<Movie> movies = movieService.findByGenre(genre);
        System.out.println("El puerto utilizado es: "+ port);
    return movies.isEmpty()
            ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(movies, HttpStatus.OK);
    }

}

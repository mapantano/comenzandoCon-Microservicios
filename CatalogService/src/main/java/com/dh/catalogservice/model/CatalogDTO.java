package com.dh.catalogservice.model;

import java.util.List;

public class CatalogDTO {

    private List<MovieDTO> movies;

    public CatalogDTO() {
        //No Args constructor
    }

    public CatalogDTO(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "CatalogDTO{" +
                "movies=" + movies +
                '}';
    }
}

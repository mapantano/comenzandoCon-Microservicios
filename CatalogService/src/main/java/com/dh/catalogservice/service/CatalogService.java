package com.dh.catalogservice.service;

import com.dh.catalogservice.model.CatalogDTO;
import com.dh.catalogservice.model.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private MovieFeignClient movieFeignClient;

    @Autowired
    public CatalogService(MovieFeignClient movieFeignClient) {
        this.movieFeignClient = movieFeignClient;
    }

    public CatalogDTO findByGenre(String genre){
        ResponseEntity<List<MovieDTO>> response= movieFeignClient.findByGenre(genre);
        if (response.getStatusCode().is2xxSuccessful())
            return new CatalogDTO(response.getBody());
        return null;

    }
}

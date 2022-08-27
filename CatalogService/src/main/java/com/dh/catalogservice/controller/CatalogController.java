package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.CatalogDTO;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> findByGenre(@PathVariable("genre") String genre){
        CatalogDTO catalogDTO= catalogService.findByGenre(genre);
        return Objects.isNull(catalogDTO)
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(catalogDTO, HttpStatus.OK);
    }
}

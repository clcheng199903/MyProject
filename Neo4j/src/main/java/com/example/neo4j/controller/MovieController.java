package com.example.neo4j.controller;

import com.example.neo4j.dao.MovieRepository;
import com.example.neo4j.domain.MovieEntity;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Resource
    private MovieRepository movieRepository;

    //method implementations with walkthroughs below
    @PutMapping
    MovieEntity createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" })
    List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/by-title")
    MovieEntity byTitle(@RequestParam String title) {
        return movieRepository.findOneByTitle(title);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        movieRepository.deleteById(id);
    }
}

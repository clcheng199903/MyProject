package com.example.neo4j.dao;

import com.example.neo4j.domain.MovieEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @description:
 * @author: cheng
 * @time: 2023/8/23 16:15
 */
public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {
    MovieEntity findOneByTitle(String title);
}

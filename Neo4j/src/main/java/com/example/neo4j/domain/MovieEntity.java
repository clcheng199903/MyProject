package com.example.neo4j.domain;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Movie节点的实体类
 * @author: cheng
 * @time: 2023/8/23 15:27
 */
@Getter
@Node("Movie") // value和labels是等价的，隐式指定类名作为label
public class MovieEntity {

    @Id // 每个实体必须有一个id，如果实体没有唯一的id，可以使用@Id + @GeneratedValue设置使用Neo4j内部的UUID
    private final String title;

    @Property("tagline") // 为标识符指定不同的别名，用于关联Movie的属性
    private final String description;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING) // 相对于Movie，是从Person指向Movie的
    private List<PersonEntity> directors = new ArrayList<>(); // 定义Movie与Person节点的关系

    public MovieEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setDirectors(List<PersonEntity> directors) {
        this.directors = directors;
    }
}

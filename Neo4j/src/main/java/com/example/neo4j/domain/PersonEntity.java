package com.example.neo4j.domain;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @description:
 * @author: cheng
 * @time: 2023/8/23 15:45
 */
@Node("Person")
@Data
public class PersonEntity {
    @Id
    @GeneratedValue
    private String id; // 使用neo4j内部id

    private final Integer born; // 不写@Property就使用标识符作为属性名


    private final String name;

    /**
     * wither-Method
     * @param id
     * @return
     */
    // This is a so-called wither for the id-attribute. It creates a new entity and sets the field accordingly, without modifying the original entity, thus making it immutable.
    // 它创建一个新实体并相应地设置字段，而不修改原始实体，从而使其不可变。
    public PersonEntity withId(String id) { // don’t find a good business key or don’t want to use a generator for IDs;
        if (this.id.equals(id)) {
            return this;
        } else {
            PersonEntity person = new PersonEntity(this.born, this.name);
            person.id = id;
            return person;
        }
    }
}

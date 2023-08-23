package com.example.authorization.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = -1;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_name")
    private String menuName;
}

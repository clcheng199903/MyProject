package com.example.jpademo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity     // 实体类
@Table(name = "users")      // 数据表名
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增
    @Column(name = "id")
    @Id     // 主键
    private int id;

    @Column(name = "username")      // username列
    private String username;

    @Column(name = "password")      // password列
    private String password;
}

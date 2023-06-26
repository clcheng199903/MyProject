package com.example.mybatisdemospringmutildatasource.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Record {
    private Long ts; // 查询没问题，Date和long插入都有问题
//    private Timestamp ts; // 查询也没问题，插入也没问题
    private Double value;
}

package com.example.mybatisdemospringmutildatasource.mapper.sqlserver;

import com.example.mybatisdemospringmutildatasource.domain.Person;
import com.example.mybatisdemospringmutildatasource.domain.TPSSM11;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper {
    List<Person> selectPersonList();
}

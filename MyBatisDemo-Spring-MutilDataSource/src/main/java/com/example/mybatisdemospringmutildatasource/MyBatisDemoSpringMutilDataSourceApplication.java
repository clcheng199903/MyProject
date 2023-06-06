package com.example.mybatisdemospringmutildatasource;

import com.example.mybatisdemospringmutildatasource.domain.Person;
import com.example.mybatisdemospringmutildatasource.domain.Student;
import com.example.mybatisdemospringmutildatasource.domain.TPSSM11;
import com.example.mybatisdemospringmutildatasource.domain.TimeZone;
import com.example.mybatisdemospringmutildatasource.mapper.mysql.TimeZoneMapper;
import com.example.mybatisdemospringmutildatasource.mapper.oracle.StudentMapper;
import com.example.mybatisdemospringmutildatasource.mapper.sqlserver.PersonMapper;
import com.example.mybatisdemospringmutildatasource.mapper.sqlserver.TPSSM11Mapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MyBatisDemoSpringMutilDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoSpringMutilDataSourceApplication.class, args);
    }

    @Resource
    private TimeZoneMapper timeZoneMapper;

//    @Resource
//    private TPSSM11Mapper tpssm11Mapper;

    @Resource
    private PersonMapper personMapper;

    @Resource
    private StudentMapper studentMapper;



    @PostConstruct
    public void init() {
        List<TimeZone> timeZones = timeZoneMapper.selectTimeZoneList();
        log.info("TimeZone Size: {}", timeZones.size());

//        List<TPSSM11> tpssm11s = tpssm11Mapper.selectTPSSM11List();
//        log.info("TPSSM11 Size: {}", tpssm11s.size());
        List<Person> people = personMapper.selectPersonList();
        log.info("Person list size: {}", people.size());

        List<Student> students = studentMapper.selectStudentList();
        log.info("Student lise size: {}", students.size());
    }
}

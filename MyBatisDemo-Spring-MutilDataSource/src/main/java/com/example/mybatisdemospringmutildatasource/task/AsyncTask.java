package com.example.mybatisdemospringmutildatasource.task;

import com.example.mybatisdemospringmutildatasource.domain.Person;
import com.example.mybatisdemospringmutildatasource.domain.Student;
import com.example.mybatisdemospringmutildatasource.domain.TimeZone;
import com.example.mybatisdemospringmutildatasource.mapper.mysql.TimeZoneMapper;
import com.example.mybatisdemospringmutildatasource.mapper.oracle.StudentMapper;
import com.example.mybatisdemospringmutildatasource.mapper.sqlserver.PersonMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AsyncTask {
    @Resource
    private TimeZoneMapper mysqlMapper;

    @Resource
    private PersonMapper sqlserverMapper;

    @Resource
    private StudentMapper oracleMapper;

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void mysqlTask() {
        List<TimeZone> timeZones = mysqlMapper.selectTimeZoneList();
        log.info("mysql size: {}", timeZones.size());

    }

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void sqlserverTask() {
        List<Person> people = sqlserverMapper.selectPersonList();
        log.info("sqlserver size: {}", people.size());
    }

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void oracleTask() {
        List<Student> students = oracleMapper.selectStudentList();
        log.info("oracle size: {}", students);
    }
}

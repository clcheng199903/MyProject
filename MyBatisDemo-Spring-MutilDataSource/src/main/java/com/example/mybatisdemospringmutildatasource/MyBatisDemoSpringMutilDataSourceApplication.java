package com.example.mybatisdemospringmutildatasource;

import com.example.mybatisdemospringmutildatasource.domain.*;
import com.example.mybatisdemospringmutildatasource.domain.Record;
import com.example.mybatisdemospringmutildatasource.mapper.mysql.BMMSM21Mapper;
import com.example.mybatisdemospringmutildatasource.mapper.mysql.TimeZoneMapper;
import com.example.mybatisdemospringmutildatasource.mapper.oracle.StudentMapper;
import com.example.mybatisdemospringmutildatasource.mapper.sqlserver.PersonMapper;
import com.example.mybatisdemospringmutildatasource.mapper.sqlserver.TPSSM11Mapper;
import com.example.mybatisdemospringmutildatasource.mapper.tdengine.RecordMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
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

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private BMMSM21Mapper bmmsm21Mapper;

    @PostConstruct
    public void production() {
        BMMSM21 bmmsm21 = new BMMSM21();
        bmmsm21.setREC_CREATE_TIME("20230609004712");
        bmmsm21.setREC_CREATOR("ccl");
        bmmsm21.setPONO("4");
        bmmsm21.setBOF_NO("4");
        bmmsm21.setSMELT_DIV("4");
        bmmsm21.setTSC_C(4);

        int i = bmmsm21Mapper.insertBofProduction(bmmsm21);
        log.info("插入成功{}条记录", i);

    }


//    @PostConstruct
    public void init() {
        List<TimeZone> timeZones = timeZoneMapper.selectTimeZoneList();
        log.info("TimeZone Size: {}", timeZones.size());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        TZ tz = new TZ(timeZones.size() + 1, dateFormat.format(new Date()), null, null);
        int i = timeZoneMapper.insertTZ(tz);
        TimeZone timeZone = timeZoneMapper.selectTimeZoneLast();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        log.info("最新的记录时间：{}", dateFormat1.format(timeZone.getBirthday()));
//
//        TimeZone timeZone = new TimeZone();
//        timeZone.setId(timeZones.size() + 1);
//        int i = timeZoneMapper.insertTimeZone(timeZone);
        log.info("插入TimeZone表成功{}", i);
//
//        List<Person> people = personMapper.selectPersonList();
//        log.info("Person list size: {}", people.size());
//
//        List<Student> students = studentMapper.selectStudentList();
//        log.info("Student lise size: {}", students.size());

        /**
         * 查询正常
         */
//        List<Record> records = recordMapper.selectRecordList();
//        Record record = new Record();
//        record.setTs(new Date());
//        record.setValue(100.0);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        String ts = dateFormat.format(record.getTs());
//        log.info(ts);
//        int i1 = recordMapper.insertRecord("tb_db_1001", dateToTimeStamp(record.getTs()), record.getValue());
//        log.info("tdengine size: {}, 插入：{}条, record: {}", records.size(), i1, record);
    }
    
    private Timestamp dateToTimeStamp(Date date) {
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
}

package com.example.mybatisdemospringmutildatasource.mapper.tdengine;

import com.example.mybatisdemospringmutildatasource.domain.Record;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RecordMapper {
    List<Record> selectRecordList(String table);

    int insertRecord(String table, Timestamp ts, double value);
}

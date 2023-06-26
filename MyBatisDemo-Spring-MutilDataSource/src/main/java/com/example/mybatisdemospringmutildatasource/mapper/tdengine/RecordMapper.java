package com.example.mybatisdemospringmutildatasource.mapper.tdengine;

import com.example.mybatisdemospringmutildatasource.domain.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RecordMapper {
    List<Record> selectRecordList(String table);

    int insertRecord(String table, long ts, double value);


    /**
     * 查询时间区间内的时序数据
     * @param table
     * @param startTime
     * @param endTime
     * @return
     */
    List<Record> selectTimeRecordList(@Param("table") String table, @Param("startTime") long startTime, @Param("endTime") long endTime);

    /**
     * 以插值的方式查询时间区间内的时序数据
     * @param table
     * @param startTime
     * @param endTime
     * @return
     */
    List<Record> selectTimeRecordListByFill(@Param("table") String table, @Param("startTime") long startTime, @Param("endTime") long endTime);
}

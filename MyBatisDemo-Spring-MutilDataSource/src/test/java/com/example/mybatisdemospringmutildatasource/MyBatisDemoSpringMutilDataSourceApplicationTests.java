package com.example.mybatisdemospringmutildatasource;

import com.example.mybatisdemospringmutildatasource.domain.Record;
import com.example.mybatisdemospringmutildatasource.mapper.tdengine.RecordMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisDemoSpringMutilDataSourceApplicationTests {

    @Resource
    private RecordMapper mapper;

    @Test
    void contextLoads() {
        List<Record> records = mapper.selectTimeRecordList("CC01S1.CastingSpeedAct", 1687627812021l, 1687656764681l);
        double v = timeToLength(records);
        System.out.println(v);

        List<Record> records1 = mapper.selectTimeRecordListByFill("CC01S1.CastingSpeedAct", 1687627812021l, 1687656764681l);
        double v1 = timeToLength(records1);
        System.out.println(v1);
    }

    public double timeToLength(List<Record> speedList) {
        double length = 0;
        if (speedList != null) {
            for (int i = 1; i < speedList.size(); i++) {
                long timeSpan = speedList.get(i).getTs() - speedList.get(i - 1).getTs();
                double avgSpeed = (speedList.get(i).getValue() + speedList.get(i - 1).getValue()) / 2;
                double lenDelta = (timeSpan * avgSpeed) / (60 * 1000);
                length += lenDelta;
            }
        }
        return length;
    }

}

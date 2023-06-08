package com.example.mybatisdemospringmutildatasource.mapper.mysql;

import com.example.mybatisdemospringmutildatasource.domain.TZ;
import com.example.mybatisdemospringmutildatasource.domain.TimeZone;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeZoneMapper {
    List<TimeZone> selectTimeZoneList();

    TimeZone selectTimeZoneLast();

    int insertTimeZone(TimeZone timezone);

    int insertTZ(TZ tz);
}

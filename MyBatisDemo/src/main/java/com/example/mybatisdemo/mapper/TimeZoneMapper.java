package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.domain.TimeZone;

import java.util.List;

public interface TimeZoneMapper {
    List<TimeZone> selectTimeZoneList();
}

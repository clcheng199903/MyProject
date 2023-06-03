package com.example.mybatisspring.mapper;

import com.example.mybatisspring.domain.TimeZone;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeZoneMapper {
//    @Select("select * from timezone")
    List<TimeZone> selectTimeZoneList();
}

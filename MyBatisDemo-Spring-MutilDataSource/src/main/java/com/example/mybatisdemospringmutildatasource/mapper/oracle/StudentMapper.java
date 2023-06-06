package com.example.mybatisdemospringmutildatasource.mapper.oracle;

import com.example.mybatisdemospringmutildatasource.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> selectStudentList();
}

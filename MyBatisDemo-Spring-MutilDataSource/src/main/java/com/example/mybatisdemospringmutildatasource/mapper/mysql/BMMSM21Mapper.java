package com.example.mybatisdemospringmutildatasource.mapper.mysql;

import com.example.mybatisdemospringmutildatasource.domain.BMMSM21;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * MES BMMSM21(BOF) 数据访问层
 */
@Repository
public interface BMMSM21Mapper {
    List<BMMSM21> selectBMMSM21AfterDate(String date);

    Date selectBofProductionLastest();

    @Transactional(value = "mysqlTransactionManager")
    int insertBofProduction(BMMSM21 bmmsm21);
}

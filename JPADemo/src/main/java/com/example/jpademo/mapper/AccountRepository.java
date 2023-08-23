package com.example.jpademo.mapper;

import com.example.jpademo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Account是表的类型
 * Integer是ID的类型
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}

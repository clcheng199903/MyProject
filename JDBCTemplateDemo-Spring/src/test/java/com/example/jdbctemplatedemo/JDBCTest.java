package com.example.jdbctemplatedemo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    @Test
    public void testSqlServer() throws Exception{
        String url = "jdbc:sqlserver://www.clcheng.asia:1433;databaseName = test";
        Connection connection = DriverManager.getConnection(url, "sa", "Ustb@701");

        Statement stat = connection.createStatement();

        String sql = "select count(*) from person";
        ResultSet resultSet = stat.executeQuery(sql);

        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
        }


        if (stat != null) {
            stat.close();
        }
        if (connection != null){
            connection.close();
        }
    }

    @Test
    public void testOracle() throws Exception{
        String url = "jdbc:oracle:thin:@www.clcheng.asia:1521:FREE";
        Connection connection = DriverManager.getConnection(url, "system", "Ustb@701");

        Statement stat = connection.createStatement();

//        String sql = "SELECT SYSTEM\".\"student\".* FROM \"SYSTEM\".\"student\" OFFSET 0 ROWS FETCH NEXT 1000 ROWS ONLY\n";
//        String sql = "select count(\"system\".\"student\".*) from \"system\".\"student\"";
        /**
         * oracle中，双引号被当作普通的字符串来处理
         */
        String sql = "select count(*) from \"student\"";
        ResultSet resultSet = stat.executeQuery(sql);

        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
        }


        if (stat != null) {
            stat.close();
        }
        if (connection != null){
            connection.close();
        }
    }
}

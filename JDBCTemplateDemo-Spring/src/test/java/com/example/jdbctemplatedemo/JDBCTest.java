package com.example.jdbctemplatedemo;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.text.SimpleDateFormat;

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

    @Test
    public void testMysql() throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // &serverTimezone=GMT%2B8
        String url = "jdbc:mysql://www.clcheng.asia:3306/test?characterEncoding=utf8&useSSL=false&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true&autoReconnect=true";
        Connection connection = DriverManager.getConnection(url, "root", "Ustb@701");
        Statement statement = connection.createStatement();
        String sql = "select id, birthday from timezone order by birthday desc limit 1";
//        Date date = new Date();
//        String insertSql = "insert into timezone (birthday) values (\"20230620113800\")";
//        statement.execute(insertSql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
//            Timestamp birthday = resultSet.getTimestamp("birthday");
            Timestamp birthday = resultSet.getTimestamp("birthday");
//            System.out.println(birthday.getHours());
//            long ts = birthday.getTime(); // 返回时间戳
//            java.util.Date date = new java.util.Date(ts);
//            System.out.println(id + " " + birthday);
//            System.out.println(date);
            System.out.println(id + " " + dateFormat.format(birthday));
        }
    }

    @Test
    public void testTimeResolver() {

    }
}

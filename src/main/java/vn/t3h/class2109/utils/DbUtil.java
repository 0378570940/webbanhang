package vn.t3h.class2109.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class DbUtil {
    public static String URL = "jdbc:mysql://localhost:3305/baitaplons";
    public static String USER_NAME = "root";
    public static String PASS_WORRD = "123456";
    public static boolean saveDb(String sql) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORRD);
            Statement statement = connection.createStatement();// có tham số
            statement.execute(sql);
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            // bước 6 đóng connecttion
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    public static boolean delete(String table, Object id, JdbcTemplate jdbcTemplate) {
        StringBuilder sql = new StringBuilder("DELETE FROM ")
        .append(table).append(" where id =")
        .append(id.toString());
        sql.append(id);
        try {
            jdbcTemplate.execute(sql.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static ResultSet excuteQuery(String sql) {
        ResultSet result = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORRD);
            Statement statement = connection.createStatement();// có tham số
            result =statement.executeQuery(sql);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            // bước 6 đóng connecttion
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}

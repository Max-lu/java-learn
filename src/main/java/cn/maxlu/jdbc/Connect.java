package cn.maxlu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by luwei on 2017/5/31.
 */
public class Connect {

    //为了代码中不暴露具体的数据库信息，提交时应该修改为非真实的信息
    static final String IP = "10.24.1.84";
    static final String USER = "root";
    static final String PASSWORD = "admin";
    static final String TEST_TABLE_NAME = "luweitest";

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/test", IP), USER, PASSWORD);
    }
}

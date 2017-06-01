package cn.maxlu.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by luwei on 2017/4/20.
 */
public class StatementTest {

    @Test
    public void connect() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = Connect.getConnect();
            statement = conn.createStatement();
            String sqlWithoutResultSet = "insert into test values(123);";
            String sqlWithResultSet = "select * from test;";
            boolean returnState = statement.execute(sqlWithResultSet);
            if (returnState) {
                System.out.println("can get result set");
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
            } else {
                System.out.println("can't get result set");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

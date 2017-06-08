package cn.maxlu.jdbc.transaction;

import cn.maxlu.jdbc.Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * Created by luwei on 2017/5/31.
 */
public class SavepointTest {
    public static void main(String[] args) {
        savepointTest();
    }

    private static void savepointTest() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = Connect.getConnect();
            conn.setAutoCommit(false);
            statement = conn.createStatement();

            String sql1 = "INSERT into test values(123);";
            String sql2 = "INSERT into test values(456);";

            statement.execute(sql1);

            Savepoint savepoint1 = conn.setSavepoint("savepoint1");

            statement.execute(sql2);

            conn.rollback(savepoint1);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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

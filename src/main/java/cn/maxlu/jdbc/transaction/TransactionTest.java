package cn.maxlu.jdbc.transaction;

import cn.maxlu.jdbc.Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by luwei on 2017/5/31.
 */
public class TransactionTest {
    public static void main(String[] args) {
        commitNotAuto();
    }

    private static void commitAuto() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = Connect.getConnect();
            statement = conn.createStatement();
            String sql1 = "update test set col_test = 456;";
            String sql2 = "update test set col_test = 789;";
            statement.execute(sql1);

            //debug : break point here and see the value was changed to 456 in db
            statement.execute(sql2);

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

    private static void commitNotAuto() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = Connect.getConnect();

            conn.setAutoCommit(false);

            statement = conn.createStatement();
            String sql1 = "update test set col_test = 456;";
            String sql2 = "update test set col_test = 789;";
            statement.execute(sql1);

            //debug : break point here and see the value was NOT changed to 456 in db
            statement.execute(sql2);

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

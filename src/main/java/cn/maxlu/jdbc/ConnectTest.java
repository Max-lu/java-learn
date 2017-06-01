package cn.maxlu.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;
import static cn.maxlu.jdbc.Connect.*;

/**
 * Created by luwei on 2017/4/20.
 */
public class ConnectTest {

    @Test
    public void connect() {
        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver"); //not necessary from jdbc4.0(jdk6)
            conn = getConnection3();

            PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + TEST_TABLE_NAME);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                int a = resultSet.getInt(1);
                System.out.println(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection getConnection1() throws SQLException {
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/test", IP), USER, PASSWORD);
    }

    private Connection getConnection2() throws SQLException {
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/test?USER=%s&PASSWORD=%s", IP, USER, PASSWORD));
    }

    private Connection getConnection3() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("USER", USER);
        properties.setProperty("PASSWORD", PASSWORD);
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/test", IP), properties);
    }
}

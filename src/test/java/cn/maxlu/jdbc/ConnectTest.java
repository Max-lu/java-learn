package cn.maxlu.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Created by luwei on 2017/4/20.
 */
public class ConnectTest {
    @Test
    public void connect() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://10.24.1.84:3306/test", "root", "admin");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM luweitest");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                int a = resultSet.getInt(1);
                System.out.println(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

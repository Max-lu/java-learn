package cn.maxlu.jdbc.pool.bonecp;

import com.jolbox.bonecp.BoneCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by luwei on 2017/5/16.
 */
public class DataSourceConf {
    public static void main(String[] args) throws Exception {
        BoneCPDataSource ds = new BoneCPDataSource();
        ds.setJdbcUrl("jdbc:mysql://10.24.1.84:3306/test");
        ds.setUsername("luwei");
        ds.setPassword("luwei123");

        Connection connection = ds.getConnection();
        PreparedStatement pst = connection.prepareStatement("SELECT * FROM luweitest");
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()){
            int a = resultSet.getInt(1);
            System.out.println(a);
        }

        connection.close();
        ds.close();
    }
}

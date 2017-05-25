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
        ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
        ds.setUsername("root");
        ds.setPassword("root");

        Connection connection = ds.getConnection();
        PreparedStatement pst = connection.prepareStatement("SELECT * FROM test");
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()){
            int a = resultSet.getInt(1);
            System.out.println(a);
        }

        connection.close();
        ds.close();
    }
}

package cn.maxlu.jdbc.pool.bonecp;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by luwei on 2017/5/16.
 */
public class ManualConf {
    public static void main(String[] args) throws Exception{
        BoneCPConfig config = new BoneCPConfig();
        config.setJdbcUrl("jdbc:mysql://10.24.1.84:3306/test");
        config.setUsername("luwei");
        config.setPassword("luwei123");

        BoneCP connectionPool = new BoneCP(config);

        Connection connection = connectionPool.getConnection();
        PreparedStatement pst = connection.prepareStatement("SELECT * FROM luweitest");
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()){
            int a = resultSet.getInt(1);
            System.out.println(a);
        }

        connection.close();
        connectionPool.shutdown();
    }
}

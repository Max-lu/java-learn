package cn.maxlu.task.jcron;

import org.jcrontab.Crontab;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JobInitListener implements ServletContextListener {

    private Crontab crontab = Crontab.getInstance();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jcrontab.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println("load resource fail...");
            e.printStackTrace();
        }
        try {
            crontab.init(properties);
            addShutdownHook();
        } catch (Exception e) {
            System.out.println("crontab init fail...");
            e.printStackTrace();
        }

    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                doStop();
            }
        });
    }

    private void doStop() {
        System.out.println("try to uninit crontab");
        crontab.uninit(200);
        System.out.println("uninit crontab success");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       doStop();
    }
}

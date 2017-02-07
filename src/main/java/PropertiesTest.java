import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = PropertiesTest.class.getClassLoader().getResourceAsStream("jcrontab.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        for (Object o : properties.keySet()) {
            System.out.println("key:" + o);
            System.out.println("value:" + properties.getProperty(o.toString()));
            System.out.println("------------------");
        }
    }
}

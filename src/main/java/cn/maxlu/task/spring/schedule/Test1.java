package cn.maxlu.task.spring.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class Test1 {

    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}

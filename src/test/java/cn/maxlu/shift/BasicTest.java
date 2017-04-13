package cn.maxlu.shift;

import org.junit.Test;

/**
 * Created by luwei on 2017/4/7.
 */

/**
 * java中有三种移位运算符
 * <<:左移运算符，num << 1,相当于num乘以2
 * >>:右移运算符，num >> 1,相当于num除以2
 * >>>:无符号右移，忽略符号位，空位都以0补齐
 */
public class BasicTest {

    @Test
    public void signedShift() {
        printNum(Integer.MAX_VALUE);
        printNum(Integer.MIN_VALUE);

        int num = 7;
        printNum(num);

        num = num << 1;
        printNum(num);

        num = num >> 2;
        printNum(num);

        num = Integer.MAX_VALUE;
        printNum(num);

        num = num << 1;
        printNum(num);

        num = num >> 2;
        printNum(num);

    }

    @Test
    public void unsignedShift() {

        int num = 7;
        printNum(num);

        num = num >>> 1;
        printNum(num);

        num = Integer.MIN_VALUE;
        printNum(num);

        num = num >>> 1;
        printNum(num);

    }

    private void printNum(int num) {
        System.out.println("---------------------");
        System.out.println("10radix:" + num);
        System.out.println(" 2radix:" + Integer.toBinaryString(num));
    }
}

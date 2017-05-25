package cn.maxlu.java.learn.basic.keywords.staticc;

/**
 * Created by max.lu on 2016/1/27.
 */
/*
static定义的变量会优先于任何其它非static变量，不论其出现的顺序如何。正如在程序中所表现的，虽然v出现在v1和v2的前面，
但是结果却是v1和v2的初始化在v的前面。在static{后面跟着一段代码，这是用来进行显式的静态变量初始化，这段代码只会初始化一次，
且在类被第一次装载时。如果你能读懂并理解这段代码，会帮助你对static关键字的认识。在涉及到继承的时候，会先初始化父类的static变量，
然后是子类的，依次类推。非静态变量不是本文的主题，在此不做详细讨论，请参考Think in Java中的讲解
 */
public class Count {
    public static void prt(String s) {
        System.out.println(s);
    }

    Value v = new Value(10);
    static Value v1, v2;

    static {
        prt("v1.c=" + v1.c + " v2.c=" + v2.c);
        v1 = new Value(27);
        prt("v1.c=" + v1.c + " v2.c=" + v2.c);
        v2 = new Value(15);
        prt("v1.c=" + v1.c + " v2.c=" + v2.c);
    }

    public static void main(String[] args) {
        Count ct = new Count();
        prt("ct.c=" + ct.v.c);
        prt("v1.c=" + v1.c + " v2.c=" + v2.c);
        v1.inc();
        prt("v1.c=" + v1.c + " v2.c=" + v2.c);
        prt("ct.c=" + ct.v.c);
    }
}

package cn.maxlu.java.learn.basic.interfacee;

public interface Person {
    default void print(){
        System.out.println("person");
    }

    //can't be overwrite
    static void print2() {
        System.out.println("static");
    }
}

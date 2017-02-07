package interfaceT;

public interface Person {
    default void print(){
        System.out.println("default");
    }

    //can't be overwrite
    static void print2() {
        System.out.println("static");
    }
}

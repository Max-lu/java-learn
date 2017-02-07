package innerclass;

public class Test {
    public static void main(String[] args) {
        Outter.A a = new Outter.A();
        a.a();

        Outter outter = new Outter();
        Outter.B b = outter.new B();
        b.b();
    }
}

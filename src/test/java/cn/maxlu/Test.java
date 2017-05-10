package cn.maxlu;

/**
 * Created by lw on 2016/7/18.
 */

public class Test {


    public static void main(String[] args) throws Exception {
        String o = get();
        CharSequence a = get();

        System.out.println(o);
        System.out.println(o.getClass());
        System.out.println(a);
        System.out.println(a.getClass());
    }

    public static <S> S get() {
        S s = (S)("123");
        return s;
    }

}

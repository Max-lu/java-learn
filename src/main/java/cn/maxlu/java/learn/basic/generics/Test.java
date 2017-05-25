package cn.maxlu.java.learn.basic.generics;

/**
 * Created by max.lu on 2016/2/2.
 */
class Test {
    public static void main(String[] args) {
        System.out.println(method1("1"));
        Book<String> book = new Book<>();
        book.setAttr("1");
        System.out.println(method2(book));

        Book<Integer> book2 = new Book<>();
        book2.setAttr(1);
        System.out.println(method3(book2));
        Path<String> path = new Path<>();
        Path<String> stringPath = path.<String>get();
    }


    public static <T> T method1(T object) {
        if (object instanceof String) {
            return object;
        }
        return null;
    }

    public static <T> T method2(Book<T> book) {
        return book.getAttr();
    }

    public static Number method3(Book<? extends Number> book) {
        return book.getAttr();
    }
}

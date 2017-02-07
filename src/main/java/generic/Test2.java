package generic;

public class Test2 {
    public static void main(String[] args) {

        Box<String> name = new Box<>("corn");
        Box<Integer> age = new Box<>(712);
        Box<Number> number = new Box<>(314);

        getData(name);
        getData(age);
        getData(number);

        getData2(name);
        getData2(age);
        getData2(number);
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    public static <T> void getData2(Box<T> data) {
        System.out.println("data :" + data.getData());
    }


}

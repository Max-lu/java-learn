package singleton;

//枚举类自动实现序列化，前四种方法均需自行实现序列化以防反序列化时创建新实例
public enum LazySingleton5 {
    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

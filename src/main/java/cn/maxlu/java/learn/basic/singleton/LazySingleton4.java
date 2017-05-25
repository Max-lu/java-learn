package cn.maxlu.java.learn.basic.singleton;

class LazySingleton4 {

    //加载一次
    private static class Holder {
        private static LazySingleton4 lazySingleton4 = new LazySingleton4();
    }

    private LazySingleton4() {
        System.out.println("call construct");
        //防止反射调用
        if (Holder.lazySingleton4 != null) {
            throw new IllegalStateException();
        }
    }

    //thread safe
    public static LazySingleton4 getInstance() {
        return Holder.lazySingleton4;
    }
}

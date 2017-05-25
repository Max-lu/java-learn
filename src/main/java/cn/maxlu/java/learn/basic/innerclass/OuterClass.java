package cn.maxlu.java.learn.basic.innerclass;

class OuterClass {
    private static class StaticInnerClass {

    }

    private class NonStaticInnerClass {

    }

    public static void main(String[] args) {
        OuterClass.StaticInnerClass a = new OuterClass.StaticInnerClass();

        //非static的内部类需要依赖外部类的实例进行实例化
        OuterClass outerClass = new OuterClass();
        OuterClass.NonStaticInnerClass b = outerClass.new NonStaticInnerClass();
    }
}

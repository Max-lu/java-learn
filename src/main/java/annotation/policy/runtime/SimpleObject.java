package annotation.policy.runtime;

/**
 * Created by max.lu on 2016/1/26.
 */
class SimpleObject {
    @TestAnnotation
    public void method1()
    {
        System.out.println("测试方法1");
    }

    @TestAnnotation(name = "max2", age = 22)
    public void method2()
    {
        System.out.println("测试方法2");
    }

    public void method3()
    {
        System.out.println("测试方法3");
    }

    public void method4()
    {
        System.out.println("测试方法4");
    }
}

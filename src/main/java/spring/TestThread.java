package spring;

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("task-" + Thread.currentThread().getName());
    }
}

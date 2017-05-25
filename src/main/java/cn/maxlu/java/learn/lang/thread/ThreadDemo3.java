package cn.maxlu.java.learn.lang.thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class ThreadDemo3 extends Thread {
    private final SyncClass syncClass;

    public ThreadDemo3(String name, final SyncClass syncClass) {
        super(name);
        this.syncClass = syncClass;
    }

    @Override
    public void run() {
        if (this.getName().equalsIgnoreCase("thread1")) {
            aa(this.getName(), "111");
        } else {
           aa(this.getName(), "222");
        }
    }

    private void aa(String threadName, String name) {
        synchronized (SyncClass.class) {
            syncClass.setName(name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " " + name);
        }
    }
}

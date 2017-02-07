package thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class Consumer extends Thread {
    private Queue queue;

    public Consumer() {

    }

    public Consumer(Queue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            queue.get();
        }
    }
}

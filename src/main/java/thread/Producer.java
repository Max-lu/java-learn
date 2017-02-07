package thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class Producer extends Thread {
    private Queue queue;

    public Producer() {
        
    }

    public Producer(Queue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            queue.put(i);
        }
    }
}

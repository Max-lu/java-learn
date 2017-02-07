package thread;

/**
 * Created by max.lu on 2016/3/2.
 */
public class NotifyTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}

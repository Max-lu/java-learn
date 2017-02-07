package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test2 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Test2 test21 = new Test2();
        Test2 test22 = new Test2();
        new Thread(test21).start();
        new Thread(test22).start();
    }

    @Override
    public void run() {
        try {
            RandomAccessFile file = new RandomAccessFile("E:\\MyProject\\Test\\src\\nio\\test.txt", "rw");
            file.seek(file.length());
            FileChannel channel = file.getChannel();
            FileLock lock = channel.lock();
            ByteBuffer buffer = ByteBuffer.allocate(20);
            byte[] bytes = Thread.currentThread().getName().getBytes();
            for (byte aByte : bytes) {
                buffer.put(aByte);
            }
            buffer.flip();
            channel.write(buffer);
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

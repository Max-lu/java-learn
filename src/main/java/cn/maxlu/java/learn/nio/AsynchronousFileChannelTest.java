package cn.maxlu.java.learn.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * Created by luwei on 2017/5/23.
 */
public class AsynchronousFileChannelTest {
    @Test
    public void futureStyle() throws Exception {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("data/test.json"), StandardOpenOption.READ, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> future = channel.read(buffer, 0);

        while (!future.isDone()) {
            System.out.println("reading...");
        }

        Integer bytes = future.get();
        System.out.println("read bytes:" + bytes);

        byte[] result = new byte[bytes];
        buffer.flip();
        buffer.get(result);
        System.out.println("read content:\n" + new String(result));
    }

    @Test
    public void callbackStyle() throws Exception {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("data/test.json"), StandardOpenOption.READ, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, 0, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer bytes, Object attachment) {
                System.out.println("completed, read bytes:" + bytes);

                byte[] result = new byte[bytes];
                buffer.flip();
                buffer.get(result);
                System.out.println("read content:\n" + new String(result));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed, exc=" + exc);
            }
        });

        Thread.sleep(20 * 1000);
    }
}

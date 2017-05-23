package cn.maxlu.java.learn.nio;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * Created by luwei on 2017/5/19.
 */
public class NioTest {

    private static final String FILE_NAME = "e:\\Test\\gc.log";

    @Test
    /**
     * FileChannel不支持非阻塞模式，因为很多文件系统不支持非阻塞模式，比如linux文件系统就不支持阻塞模式
     * 所以FileChannel没有实现SelectableChannel接口，不能注册到selector上
     * 不过java提供了AsynchronousFileChannel来支持非阻塞模式，demo<code>cn.maxlu.java.learn.nio.AsynchronousFileChannelTest</code>
     */
    public void basicUseTest() throws Exception {
        RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10); //create buffer with capacity of 10 bytes
        int readLen = channel.read(buffer); //read into buffer.

        while (readLen != -1) {
            buffer.flip(); //make buffer ready for read
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get()); // read 1 byte at a time
            }
            buffer.clear(); //make buffer ready for writing

            readLen = channel.read(buffer); //read into buffer again.
        }

        file.close();
    }

    @Test
    public void socketChannelTest() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int readLen = socketChannel.read(buffer);
        while (readLen != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            readLen = socketChannel.read(buffer);
        }

        socketChannel.close();
    }

    @Test
    public void asyncSocketChannelTest() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

        while (!socketChannel.finishConnect()) {
            System.out.println("waiting for connect");
        }

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int readLen = socketChannel.read(buffer);
        while (readLen != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            readLen = socketChannel.read(buffer);
        }

        socketChannel.close();
    }

    @Test
    public void serverSocketChannelTest() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            SocketChannel channel = serverSocketChannel.accept();
            System.out.println("a connect");
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.put("hello world\n".getBytes());

            buffer.flip();
            channel.write(buffer);
            channel.close();
        }
    }

    @Test
    public void asyncServerSocketChannelTest() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            SocketChannel channel = serverSocketChannel.accept();
            if (channel != null) {
                System.out.println("a connect");
                ByteBuffer buffer = ByteBuffer.allocate(100);
                buffer.put("hello world\n".getBytes());
                buffer.flip();

                channel.write(buffer);
                channel.close();
            }
        }
    }

    @Test
    public void datagramChannelReceiveTest() throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(8080));

        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        datagramChannel.receive(buffer);

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
    }

    @Test
    public void datagramChannelSendTest() throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open();

        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        buffer.put("hello world".getBytes());
        buffer.flip();
        datagramChannel.send(buffer, new InetSocketAddress("127.0.0.1", 8080));
    }

    @Test
    public void pipeTest() throws Exception {
        Pipe pipe = Pipe.open();

        ByteBuffer sinkBuffer = ByteBuffer.allocate(48);
        sinkBuffer.clear();
        sinkBuffer.put("hello world".getBytes());
        sinkBuffer.flip();

        ByteBuffer sourceBuffer = ByteBuffer.allocate(48);
        sinkBuffer.clear();

        Pipe.SinkChannel sink = pipe.sink();
        sink.write(sinkBuffer);

        Pipe.SourceChannel source = pipe.source();
        source.read(sourceBuffer);
        sourceBuffer.flip();
        while (sourceBuffer.hasRemaining()) {
            System.out.print((char)(sourceBuffer.get()));
        }
        sourceBuffer.clear();
    }
}

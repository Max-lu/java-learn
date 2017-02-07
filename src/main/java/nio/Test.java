package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        System.out.println(Arrays.toString(buffer.array()));
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(buffer);
        System.out.println(charBuffer.array());

        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        System.out.println(Arrays.toString(byteBuffer.array()));

    }

    private static void multiBuffer() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        ByteBuffer buffer2 = ByteBuffer.allocate(5);
        ByteBuffer[] byteBuffers = {buffer1, buffer2};
        channel.read(byteBuffers);
//        System.out.println("buffer 1:");
//        buffer1.flip();
//        while (buffer1.remaining() > 0) {
//            System.out.print(buffer1.get());
//        }
//
//        System.out.println("\nbuffer 2:");
//        buffer2.flip();
//        while (buffer2.remaining() > 0) {
//            System.out.print(buffer2.get());
//        }
//        System.out.println();


        buffer1.flip();
        buffer2.flip();
        FileOutputStream out = new FileOutputStream("E:\\MyProject\\Test\\src\\nio\\test2.txt");
        FileChannel channel2 = out.getChannel();
        channel2.write(byteBuffers);
    }

    private static void mapToMemory() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = fileInputStream.getChannel();
        channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
    }

    private static void readOnlyBuffer() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileOutputStream out = new FileOutputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = out.getChannel();
        byte[] message = {'h', 'e', 'l', 'l', 'o'};
        for (byte aMessage : message) {
            buffer.put(aMessage);
        }
        buffer.asReadOnlyBuffer();
        buffer.flip();
        channel.write(buffer);

        //throw exception, because of read only
        buffer.put((byte) 'i');
    }

    private static void slice() {
        byte[] bytes = new byte[10];
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        for (int i = 0; i < slice.capacity(); i++) {
            byte b = (byte) (slice.get(i) * 10);
            slice.put(i, b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.remaining() > 0) {
            System.out.println(buffer.get());
        }
        System.out.println();
    }


    private static void copy() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = fileInputStream.getChannel();
        FileOutputStream out = new FileOutputStream("E:\\MyProject\\Test\\src\\nio\\test2.txt");
        FileChannel channel2 = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int read = channel.read(buffer);
            if (read == -1) {
                break;
            }
            buffer.flip();
            channel2.write(buffer);
        }
    }

    private static void write() throws IOException {
        FileOutputStream out = new FileOutputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] message = {'h', 'e', 'l', 'l', 'o'};
        for (byte aMessage : message) {
            buffer.put(aMessage);
        }
        buffer.flip();
        channel.write(buffer);

        printBuffer(buffer);
    }

    private static void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\MyProject\\Test\\src\\nio\\test.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len = channel.read(buffer);
        System.out.println("len=" + len);

        printBuffer(buffer);
    }

    private static void printBuffer(ByteBuffer buffer) {
        byte[] array = buffer.array();
        for (byte b : array) {
            System.out.print((char) b);
        }
    }
}

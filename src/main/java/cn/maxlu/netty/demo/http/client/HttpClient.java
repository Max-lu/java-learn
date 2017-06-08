package cn.maxlu.netty.demo.http.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.jboss.netty.handler.codec.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by luwei on 2017/5/17.
 */

class HttpClient {

    private EventLoopGroup workerGroup;

    private BlockingQueue<String> result;

    private String host;

    private int port;

    private Channel channel;

    private HttpClient() {
        workerGroup = new NioEventLoopGroup();
        result = new ArrayBlockingQueue<>(1);
    }

    public static HttpClient get() {
        return new HttpClient();
    }

    private void shutdown() {
        workerGroup.shutdownGracefully();
    }

    public void close() {
        shutdown();
    }

    public HttpClient connect(String host, int port) throws InterruptedException {
        this.host = host;
        this.port = port;

        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new HttpResponseDecoder());
                ch.pipeline().addLast(new HttpRequestEncoder());
                ch.pipeline().addLast(new HttpClientHandler());
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                shutdown();
            }
        });

        ChannelFuture f = b.connect(host, port).sync();
        channel = f.channel();
        return this;
    }

    public synchronized String send(String msg) throws InterruptedException, URISyntaxException, UnsupportedEncodingException {
        URI uri = new URI(String.format("http://%s:%s", host, port));
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
                uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));

        // 构建http请求
        request.headers().set(HttpHeaders.Names.HOST, host);
        request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        request.headers().setInt(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());
        // 发送http请求
        channel.write(request);
        channel.flush();
        channel.closeFuture().sync();

        return result.take();
    }

    private class HttpClientHandler extends ChannelHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//            if (msg instanceof HttpResponse) {
//                HttpResponse response = (HttpResponse) msg;
//                System.err.println("CONTENT_TYPE:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE));
//            }
            if (msg instanceof HttpContent) {
                HttpContent content = (HttpContent) msg;
                ByteBuf buf = content.content();
                result.put(buf.toString(CharsetUtil.UTF_8));
                buf.release();
            }
        }
    }
}

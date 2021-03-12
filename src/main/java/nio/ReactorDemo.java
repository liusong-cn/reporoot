package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author: Administrator
 * @date: 2021/3/4 22:53
 * 利用java的nio做的reactor模型示例
 */
public class ReactorDemo {

    public static void testReactor() throws IOException {
        //开始选择器
        Selector selector = Selector.open();
        //开启serverchannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //通道设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //bind具体的客户端
        serverSocketChannel.bind(new InetSocketAddress(8099));
        //将channel注册到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //selector轮询事件
        while (selector.select() > 0){
            //获取当前选择器中已经准备就绪的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //具体的事件
                SelectionKey selectionKey = iterator.next();
                //如果是连接事件
                if(selectionKey.isAcceptable()){
                    //打开服务端的连接通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //设置非阻塞
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器并且为读事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                //如果是读事件
                }else if(selectionKey.isReadable()){
                    //获取读通道
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = channel.read(buffer)) != -1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0 , length));
                        buffer.clear();
                    }
                    //关闭通道
                    channel.close();
                }
                //移除事件
                selector.selectedKeys().remove(selectionKey);
            }

        }
        //关闭服务端channel
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        testReactor();
    }
}

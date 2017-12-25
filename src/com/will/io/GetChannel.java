package com.will.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ClassName:GetChannel
 * Description:旧I/O(jdk1.4)中FileInputStream、FileOutputStream和RandomAccessFile这三个类被修改了，可以产生FileChannel
 * 本类演示以上三个类，产生可写的、可读可写的以及可读的通道
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-25
 */
public class GetChannel {
    private static final int SIZE = 1024;

    public static void main(String[] args) throws Exception {
        /*向文档添加内容*/
        FileChannel fileChannel = new FileOutputStream("data.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("FileOutputStream".getBytes()));
        fileChannel.close();

        /*在文档最后添加内容*/
        fileChannel = new RandomAccessFile("data.txt", "rw").getChannel();
        // 定位到文档最后
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("RandomAccessFile".getBytes()));
        fileChannel.close();

        /*读取文档中的内容*/
        fileChannel = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        fileChannel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
    }
}

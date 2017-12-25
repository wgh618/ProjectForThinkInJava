package com.will.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ClassName:Demo1
 * Description:读取文件内容
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-25
 */
public class Demo1 {
    public static String read(String fileName) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuffer result = new StringBuffer();
        while ((s = bufferedReader.readLine()) != null) {
            result.append(s + "\n");
        }
        bufferedReader.close();
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(read("src/com/will/io/Demo1.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

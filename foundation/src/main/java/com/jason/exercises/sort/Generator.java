package com.jason.exercises.sort;

import java.io.*;
import java.util.Random;

/**
 * 生成一个大文件
 * Created by shanshouchen@weibangong.com on 2017/2/10.
 */
public class Generator {
    Random random = new Random();

    public static void main(String[] args) throws IOException {
        Generator generator = new Generator();
        BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File("data.num")));
        int count = 0;
        int num = 0;
        for (int i = 0; i < 1000000000; i++) {
            String line = generator.random(10000, 100000000) + "\n";
            buffer.write(line.getBytes());
            if (count > 10000) {
                num += count;
                count = 0;
                buffer.flush();
                System.out.println(num);
            }
            count++;
        }
        buffer.flush();
        buffer.close();
    }

    private int random(int min, int max) {
        return random.nextInt(max) % (max - min + 1) + min;
    }
}

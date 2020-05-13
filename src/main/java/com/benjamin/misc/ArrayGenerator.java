package com.benjamin.misc;

import java.util.Random;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/13
 */
public class ArrayGenerator {

    /**
     * 数组生成器
     *
     * @param length 数组长度
     * @return
     */
    public static int[] generate(int length) {
        Random r = new Random();

        // 新增数组
        int[] arrays = new int[length];
        // 初始化数组
        for (int i = 0; i < length; i++) {
            int next = r.nextInt(100);
            arrays[i] = next;
        }

        print(arrays);

        return arrays;
    }

    public static void main(String[] args) {
        int[] arrays = generate(10);
    }
}

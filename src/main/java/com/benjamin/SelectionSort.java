package com.benjamin;

import java.util.Arrays;

import static com.benjamin.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/13
 * <p>
 * 冒泡排序
 * <p>
 * 两个for循环，第一个for循环用于标记遍历最大的次数，第二个for循环用于选取最小的值
 */
public class SelectionSort {
    final static int LENGTH = 15;

    public static void sort(int[] arrays) {

        // 定义外层循环指针
        for (int loopIndex = 0; loopIndex < arrays.length; loopIndex++) {
            // 定义比较指针
            for (int compareIndex = 0; compareIndex < arrays.length; compareIndex++) {
                // 外循环指针值
                int loopValue = arrays[loopIndex];
                // 比较指针值
                int comparedValue = arrays[compareIndex];
                // 外循环较大，则交换
                if (loopValue < comparedValue) {
                    int tmp = arrays[loopIndex];
                    arrays[loopIndex] = arrays[compareIndex];
                    arrays[compareIndex] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 随机生成数组
        int[] arrays = ArrayGenerator.generate(LENGTH);
        sort(arrays);
        print(arrays);
    }
}

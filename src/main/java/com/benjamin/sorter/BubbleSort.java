package com.benjamin.sorter;

import com.benjamin.misc.ArrayGenerator;

import java.util.Arrays;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/13
 * <p>
 * 冒泡排序
 * <p>
 * 两个for循环，第一个for循环用于标记遍历最大的次数，第二个for循环用于交换相邻的数
 */
public class BubbleSort {
    final static int LENGTH = 15;

    public static Integer[] sort(Integer[] input) {
        Integer[] arrays = Arrays.copyOf(input,
                input.length);

        // 定义外层循环指针
        for (int loopIndex = 0; loopIndex < arrays.length; loopIndex++) {
            // 定义比较指针，数组长度-1，最后一个数不用比较
            for (int compareIndex = 0; compareIndex < arrays.length - 1; compareIndex++) {
                // 右指针
                int rightIndex = compareIndex + 1;
                // 右边值
                int rightValue = arrays[rightIndex];
                // 当前值
                int currentValue = arrays[compareIndex];

                // 数值小的给（comparedIndex）
                if (currentValue > rightValue) {
                    int tmp = arrays[compareIndex];
                    arrays[compareIndex] = arrays[rightIndex];
                    arrays[rightIndex] = tmp;
                }
            }
        }

        return arrays;
    }

    public static void main(String[] args) {
        // 随机生成数组
        Integer[] arrays = ArrayGenerator.generate(LENGTH);
        print(() -> arrays);
        print(() -> sort(arrays));
    }
}

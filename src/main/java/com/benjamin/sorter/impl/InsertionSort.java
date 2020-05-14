package com.benjamin.sorter.impl;

import com.benjamin.misc.ArrayGenerator;
import com.benjamin.sorter.Sort;

import java.util.Arrays;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/13
 * <p>
 * 插入排序
 * <p>
 * 左边序列认为是有序序列，右边元素依次向左边比较，遇到第一个比自己小的值前插入
 */
public class InsertionSort implements Sort {
    final static int LENGTH = 15;

    @Override
    public Integer[] sort(Integer[] input) {
        Integer[] arrays = Arrays.copyOf(input,
                input.length);

        // 定义外层循环指针
        for (int loopIndex = 1; loopIndex < arrays.length; loopIndex++) {
            // 缓存当前值
            int currentValue = arrays[loopIndex];

            // 有序队列指针，从右指向左
            int sortedLeftIndex = loopIndex;

            // 从有序队列最后一个开始往前比较
            while (sortedLeftIndex-- > 0) {
                // 左边值
                int sortedLeftValue = arrays[sortedLeftIndex];

                // 当前值比有序队列最大值还大
                if (currentValue >= sortedLeftValue) {
                    break;
                }
                // 当前值比有序队列左边值小
                else {
                    // 左边值往右挪一位
                    arrays[sortedLeftIndex + 1] = arrays[sortedLeftIndex];
                    // 原左边值位置，放当前值
                    arrays[sortedLeftIndex] = currentValue;
                }
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        Sort sorter = new InsertionSort();
        // 随机生成数组
        Integer[] arrays = ArrayGenerator.generate(LENGTH);
        print(() -> arrays);
        print(() -> sorter.sort(arrays));
    }

}

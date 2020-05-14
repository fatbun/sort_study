package com.benjamin.sorter.impl;

import com.benjamin.misc.ArrayGenerator;
import com.benjamin.sorter.Sort;

import java.util.Arrays;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/14
 * <p>
 * 归并排序
 * <p>
 * 引入递归、分区的概念
 *      分区：二分法对半切分
 *      递归：基于分区的概念，直到找到最小区域的分区（区域里值的数量大小为1），才开始做合并排序操作
 *
 */
public class MergeSort implements Sort {

    final static int LENGTH = 15;

    @Override
    public  Integer[] sort(Integer[] input) {
        return partition(input);
    }

    /**
     * 递归找分区后，做合并操作
     *
     * @param arrays
     * @return
     */
    private Integer[] partition(Integer[] arrays) {
        if (arrays.length <= 1) {
            return arrays;
        }

        // 左右区域对半切
        int mid = arrays.length / 2;

        Integer[] left = Arrays.copyOfRange(arrays,
                0,
                mid);
        Integer[] right = Arrays.copyOfRange(arrays,
                mid,
                arrays.length);

        // 递归切左分区，直到底部分区值数量为1（后续处理该分区已是有序分区）
        left = partition(left);
        // 递归切右分区，直到底部分区值数量为1（后续处理该分区已是有序分区）
        right = partition(right);
        // 合并左右分区，返回一个有序的分区
        return merge(left,
                right);
    }

    /**
     * 合并，生成一个有序的数组
     *
     * @param left  约定传入，有序左数组
     * @param right 约定传入，有序右数组
     * @return
     */
    private Integer[] merge(Integer[] left, Integer[] right) {
        // 有序数组大小 = 做数组长度 + 右数组长度
        Integer[] sorted = new Integer[left.length + right.length];

        // 左分区指针
        int leftIndex = 0;
        // 右分区指针
        int rightIndex = 0;
        // 有序数组指针
        int sortedindex = 0;

        while (true) {
            // 左分区越界
            if (leftIndex >= left.length) {
                break;
            }
            // 右分区越界
            if (rightIndex >= right.length) {
                break;
            }

            int leftValue = left[leftIndex];
            int rightValue = right[rightIndex];
            if (leftValue <= rightValue) {
                // pop出左区域的值
                sorted[sortedindex] = leftValue;
                // 左区域指针+1
                leftIndex++;
            } else {
                // pop出右区域的值
                sorted[sortedindex] = rightValue;
                // 右区域指针+1
                rightIndex++;
            }
            // 有序数组指针+1
            sortedindex++;
        }

        // 左分区指针越界，但右分区指针未越界，则把右分区剩下的值放进有序数组
        if (leftIndex >= left.length && rightIndex < right.length) {
            for (int i = sortedindex; i < sorted.length; i++) {
                sorted[i] = right[rightIndex];
                rightIndex++;
            }
        }

        // 右分区指针越界，但左分区指针未越界，则把左分区剩下的值放进有序数组
        if (rightIndex >= right.length && leftIndex < left.length) {
            for (int i = sortedindex; i < sorted.length; i++) {
                sorted[i] = left[leftIndex];
                leftIndex++;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        Sort sorter = new MergeSort();
        // 随机生成数组
        Integer[] arrays = ArrayGenerator.generate(LENGTH);
        print(() -> arrays);
        print(() -> sorter.sort(arrays));
    }
}

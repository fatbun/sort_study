package com.benjamin.sorter.impl;

import com.benjamin.misc.ArrayGenerator;
import com.benjamin.sorter.Sort;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/15
 * <p>
 * 大根堆排序
 * <p>
 * 大根堆概念：由一个完全二叉树组成，父节点值 必须大于或等于，左右子节点值
 * 父节点：n
 * 左子节点：2n+1
 * 右子节点：2n+2
 * <p>
 * 把数组重排序成一个大根堆数组，排序完成后pop出根部节点，放到新数组尾部
 * 重复上面的排序、pop操作，直到大根堆数组长度为2，直接pop出
 */
public class HeapSort implements Sort {
    final static int LENGTH = 15;

    @Override
    public Integer[] sort(Integer[] arrays) {
        Integer[] sorted = new Integer[arrays.length];
        int index = arrays.length - 1;

        for (int i = 0; i < arrays.length; i++) {
            // 排序：大根堆形状
            resort(arrays);
            // 最大值
            int rootValue = arrays[0];
            // 从数组最后开始往前放
            sorted[index--] = rootValue;
        }

        return sorted;
    }

    /**
     * 重新排序为大根堆
     *
     * @param arrays
     */
    private void resort(Integer[] arrays) {
        // 数组长度
        int length = arrays.length;

        // 从数组最后一个向前比较，直到指针指向根部（0）
        for (int i = length - 1; i >= 0; i--) {
            // 指针值
            int indexValue = arrays[i];
            // 计算找父节点位置
            int parentIndex = getParentIndex(i);
            // 如果子节点>父节点，则交换
            if (indexValue >= arrays[parentIndex]) {
                swap(i,
                        parentIndex,
                        arrays);
            }
        }
    }

    /**
     * @param sonIndex
     * @param parentIndex
     */
    private void swap(int sonIndex, int parentIndex, Integer[] arrays) {
        int tmp = arrays[sonIndex];
        arrays[sonIndex] = arrays[parentIndex];
        arrays[parentIndex] = tmp;
    }

    /**
     * 找父节点位置
     *
     * @param sonIndex 子节点位置
     * @return
     */
    private int getParentIndex(int sonIndex) {
        // 公式：2n+1=sonIndex ==> n=parentIndex = (sonIndex-1)/2
        // 直接用左子节点（2n+1）位置计算，因为整数相处，不四舍五入
        return (sonIndex - 1) / 2;
    }


    public static void main(String[] args) {
        Sort sorter = new BubbleSort();
        // 随机生成数组
        Integer[] arrays = ArrayGenerator.generate(LENGTH);
        print(() -> arrays);
        print(() -> sorter.sort(arrays));
    }
}

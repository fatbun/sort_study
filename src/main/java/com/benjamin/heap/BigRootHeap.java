package com.benjamin.heap;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/15
 * <p>
 * 大根堆
 * <p>
 * 对数组，重排序成一个大根堆数组：
 * 完全二叉树
 * <p>
 * 例：{4,6,8,5,9}
 * 树结构：
 * -         4
 * -      6     8
 * -    5   9
 * <p>
 * 大根堆排序：
 * -         9
 * -      8     4
 * -    5   6
 * 特性：根节点的值必须比左右子节点的值要大于或等于
 * 结论：若根节点指针位置为n，则 f(n) >= f(2n+1)，且f(n) >= f(2n+2)
 * <p>
 * 小根堆同理，只是根部值最小
 * 特性：根节点的值必须比左右子节点的值要小于或等于
 * 结论：若根节点指针位置为n，则 f(n) <= f(2n+1)，且f(n) <= f(2n+2)
 */
public class BigRootHeap {

    /**
     * 对传入的数组，重排为大根堆
     *
     * @param arrays
     */
    private void sort(Integer[] arrays) {
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
        Integer[] arr = new Integer[]{4, 6, 8, 5, 9};
        BigRootHeap heap = new BigRootHeap();
        heap.sort(arr);
        print(() -> arr);
    }
}

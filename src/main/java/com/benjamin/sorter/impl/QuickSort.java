package com.benjamin.sorter.impl;

import com.benjamin.misc.ArrayGenerator;
import com.benjamin.sorter.Sort;

import java.util.Arrays;

import static com.benjamin.misc.Print.print;

/**
 * Created by Ben Li.
 * Date: 2020/5/14
 * <p>
 * 快速排序
 * <p>
 * 升级版的归并排序：
 * 选出数组中任意一个位置上的数值作为基准（"中点"），比它小的放在左边，比它大的放在右边，然后做归并（递归合并）
 */
public class QuickSort implements Sort {
    // 数组长度
    final static int LENGTH = 15;
    // 基准点指针位置
    final static int PIVOT = 0;

    @Override
    public Integer[] sort(Integer[] arrays) {
        // 开始递归重排
        return partition(arrays);
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

        // 以基准点重新排序数组
        ResortPojo pojo = resort(arrays);

        // 排序后数组长度小于等于2，直接返回
        if (pojo.getArrays().length <= 2) {
            return pojo.getArrays();
        }

        // 提取左区域
        Integer[] left = Arrays.copyOfRange(pojo.getArrays(),
                0,
                pojo.getPivotindex());
        // 提取右区域（不含基准位置）
        Integer[] right = Arrays.copyOfRange(pojo.getArrays(),
                pojo.getPivotindex() + 1,
                arrays.length);
        // 基准值
        int pivotValue = pojo.getArrays()[pojo.getPivotindex()];

        left = partition(left);
        right = partition(right);

        return merge(left,
                right,
                pivotValue);
    }

    /**
     * 以基准点为"中点"，重排数组，小的放左边，大的放右边
     *
     * @param arrays
     */
    public ResortPojo resort(Integer[] arrays) {
        Integer[] sorted = new Integer[arrays.length];
        // 左指针，指向数组首位
        int leftIndex = 0;
        // 右指针，指向数组末位
        int rightIndex = arrays.length - 1;

        // 基准值
        int pivotValue = arrays[PIVOT];
        for (int i = 1; i < arrays.length; i++) {
            // 小于等于基准值，放数组左边
            if (arrays[i] <= pivotValue) {
                sorted[leftIndex] = arrays[i];
                // 左指针右移
                leftIndex++;
            }
            // 大于基准值，放数组右边
            else {
                sorted[rightIndex] = arrays[i];
                // 右指针左移
                rightIndex--;
            }

            // 当左右指针相等（相遇），即是基准值新位置，完成重排
            if (leftIndex == rightIndex) {
                sorted[leftIndex] = pivotValue;
                break;
            }
        }

        return new ResortPojo(sorted,
                leftIndex);
    }


    /**
     * 左右区域合并
     * 左区域一定是小于右区域，且左右区域均有序，因此左右区域直接合并即可
     *
     * @param left       左有序数组
     * @param right      右有序数组
     * @param pivotValue 基准值
     * @return
     */
    public Integer[] merge(Integer[] left, Integer[] right, int pivotValue) {
        Integer[] sorted = new Integer[left.length + right.length + 1];

        // 添加左数组到sorted
        System.arraycopy(left,
                0,
                sorted,
                0,
                left.length);

        // 添加基准值
        sorted[left.length] = pivotValue;

        // 添加右数组到sorted
        System.arraycopy(right,
                0,
                sorted,
                left.length + 1,
                right.length);

        return sorted;
    }

    class ResortPojo {
        /**
         * 排序后数组
         */
        private Integer[] arrays;

        /**
         * 排序后基准指针位置
         */
        private Integer pivotindex;

        public ResortPojo() {
        }

        public ResortPojo(Integer[] arrays, Integer pivotindex) {
            this.arrays = arrays;
            this.pivotindex = pivotindex;
        }

        public Integer[] getArrays() {
            return arrays;
        }

        public void setArrays(Integer[] arrays) {
            this.arrays = arrays;
        }

        public Integer getPivotindex() {
            return pivotindex;
        }

        public void setPivotindex(Integer pivotindex) {
            this.pivotindex = pivotindex;
        }
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();

        // 随机生成数组
        Integer[] arrays = ArrayGenerator.generate(LENGTH);
        print(() -> arrays);
        print(() -> sorter.sort(arrays));
    }
}

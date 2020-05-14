package com.benjamin.misc;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Created by Ben Li.
 * Date: 2020/5/13
 */
public class Print {

    public static void print(Supplier<Integer[]> supplier) {

        long startTime = System.nanoTime();
        Integer[] sorted = supplier.get();
        long endTime = System.nanoTime();

        System.out.print("arrays：" + Arrays.asList(sorted));
        System.out.println(" 耗时：" + (endTime - startTime));

    }
}

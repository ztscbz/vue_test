package com.zt.m08day31;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/9/2 16:00
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        test(arr);
        test(arr);
        System.out.println(arr);

        System.out.println(3/2);
    }

    private static void test(List<String> arr){
        arr.add("15");
    }
}

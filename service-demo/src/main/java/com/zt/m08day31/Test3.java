package com.zt.m08day31;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/9/3 10:33
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        for (String s : arr) {
            System.out.println(s);
        }

        System.out.println("1".equals(null));
        System.out.println(Objects.equals(null,null));
    }
}

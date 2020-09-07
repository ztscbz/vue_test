package com.zt.m08day07;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/8/28 9:49
 */
public class Test8 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("11");
        arr.add("22");
        arr.add("33");
        String join = StringUtils.join(arr, ",");
        System.out.println(join);
        System.out.println(LocalDateTime.now().getYear());
        System.out.println(LocalDateTime.now().getMonthValue());
        Short s = 1;
        System.out.println(s == 1);
    }
}

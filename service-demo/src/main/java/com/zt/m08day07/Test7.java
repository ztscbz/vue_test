package com.zt.m08day07;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/8/24 14:52
 */
public class Test7 {
    public static void main(String[] args) {
        System.out.println("开始了。。。。。");
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 222;
        i += 222;
        System.out.println(i);
    }
}

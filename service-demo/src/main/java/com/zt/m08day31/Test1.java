package com.zt.m08day31;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/9/1 15:24
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Short s1 = 2;
        Short s2 = 2;
        String str = objectMapper.writeValueAsString(new PeoVo(15556555L, s1, s2));
        System.out.println(str);

        PeoVo peoVo = objectMapper.readValue(str, PeoVo.class);
        System.out.println(peoVo);
    }
}

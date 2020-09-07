package com.zt.test.service.impl;

import com.zt.m08day31.PeoVo;
import com.zt.test.service.TestAopService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/9/7 16:00
 */
@Service
public class TestAopServiceImpl implements TestAopService {

    @Override
    public void addPeoVo(PeoVo peoVo) {
        System.out.println("新增了。。。");
    }
}

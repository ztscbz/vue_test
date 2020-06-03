package com.zt.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.test.mapper.TestMapper;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;
import com.zt.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZT
 * @date 2020/6/3
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper mapper;

    @Override
    public PageInfo<Test> queryTest(TestQuery param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        PageInfo info = new PageInfo(mapper.queryTest(param));
        return info;
    }
}

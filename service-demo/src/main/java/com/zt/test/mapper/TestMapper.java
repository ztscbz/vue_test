package com.zt.test.mapper;

import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;

import java.util.List;

/**
 * @author ZT
 * @date 2020/6/3
 */
public interface TestMapper {

    List<Test> queryTest(TestQuery param);
}

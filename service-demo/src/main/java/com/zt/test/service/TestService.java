package com.zt.test.service;

import com.github.pagehelper.PageInfo;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;

/**
 * @author ZT
 * @date 2020/6/3
 */
public interface TestService {

    /**
     * @description: 测试查询
     * @author ZT
     * @Date 2020/6/3 20:16
     * @Param  @param param
     * @return com.github.pagehelper.PageInfo<com.zt.test.po.Test>
    */
    PageInfo<Test> queryTest(TestQuery param);
}

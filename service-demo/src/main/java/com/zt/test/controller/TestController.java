package com.zt.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;
import com.zt.test.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZT
 * @date 2020/6/3
 */
@RestController
@RequestMapping("test")
@Api(tags = "测试查询")
public class TestController {

    @Autowired
    private TestService service;

    @ApiOperation(value = "测试类查询")
    @PostMapping("queryTest")
    public PageInfo<Test> queryTest(@RequestBody TestQuery param) {
        return service.queryTest(param);
    }
}

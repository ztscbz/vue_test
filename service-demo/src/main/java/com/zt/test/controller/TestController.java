package com.zt.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.entiy.TreeNode;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;
import com.zt.test.service.TestService;
import com.zt.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "测试无返回值")
    @PostMapping("test")
    public void test(){
        System.out.println("hello");
    }

    @ApiOperation(value = "测试有返回值")
    @PostMapping("test1")
    public String test1(){
       return "Hello World";
    }

    @ApiOperation(value = "测试错误")
    @PostMapping("test2")
    public String test2(){
        int i = 1/0;
        return "Hello World";
    }

    @GetMapping("queryDeptNode")
    public List<TreeNode> queryTreeNode(String id) {
        return service.queryTreeNode(id);
    }

    @GetMapping("setValue")
    @ApiOperation("设置字符串缓存")
    public String setValue(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        RedisUtil.set(str,"zt" + str);
        return "zt" + str;
    }

    @GetMapping("getValue")
    @ApiOperation("取出字符串缓存")
    public String getValue(String str){
        return (String) RedisUtil.get(str);
    }
}

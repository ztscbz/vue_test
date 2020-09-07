package com.zt.test.controller;

import com.github.pagehelper.PageInfo;
import com.zt.config.RabbitMqAnnexConfig;
import com.zt.entiy.TreeNode;
import com.zt.group.Add;
import com.zt.group.Update;
import com.zt.m08day07.Test4;
import com.zt.test.po.TestVo;
import com.zt.test.query.TestQuery;
import com.zt.test.service.TestService;
import com.zt.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation(value = "测试类查询")
    @PostMapping("queryTest")
    public PageInfo<TestVo> queryTest(@RequestBody @Valid TestQuery param) {
        return service.queryTest(param);
    }

    @ApiOperation(value = "测试校验新增")
    @PostMapping("addValidTest")
    public String addValidTest(@RequestBody @Validated({Add.class}) TestQuery param) {
        return "addValidTest" + param.toString();
    }

    @ApiOperation(value = "测试校验修改")
    @PostMapping("updateValidTest")
    public String updateValidTest(@RequestBody @Validated({Update.class}) TestQuery param) {
        return "updateValidTest" + param.toString();
    }

    @ApiOperation(value = "测试无返回值")
    @GetMapping("test")
    public String test(Integer id){
        System.out.println("hello" + id);
        return "hello" + id;
    }

    @ApiOperation(value = "测试有返回值")
    @GetMapping("test1")
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

    @PostMapping("upload")
    @ApiOperation(value = "minio通用文件上传")
    @ApiImplicitParam(name="file",dataType="__file",required=true,value="图片流文件")
    public String upload(MultipartFile file){
        return service.upload(file);
    }

    @PostMapping("getPicUri")
    @ApiOperation(value = "获取视频图片  文件")
    @ApiImplicitParam(name="file",dataType="__file",required=true,value="图片流文件")
    public String getPicUri(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String name = file.getName();
        System.out.println(name);
        File file1= new File(originalFilename);
        FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
        Test4.getVideoPic(file1,"D:\\pic\\video.jpg");
        return "1111";
    }

    @PostMapping("getPicUrl")
    @ApiOperation(value = "获取视频图片  流")
    @ApiImplicitParam(name="file",dataType="__file",required=true,value="图片流文件")
    public String getPicUrl(MultipartFile file) throws IOException {
        String url = "D:\\pic\\"+ System.currentTimeMillis() + ".jpg";
        Test4.getVideoPic1(file.getInputStream(),url);
        return url;
    }

    @GetMapping("sendMessage")
    @ApiOperation("发送消息")
    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(RabbitMqAnnexConfig.ATLP_TOPIC_EXCHANGE,
                RabbitMqAnnexConfig.TOPIC_ROUTINGKEY, message);
    }
}

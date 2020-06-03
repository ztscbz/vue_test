package com.zt.test.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZT
 * @date 2020/6/3
 */
@ApiModel(value = "测试类")
@Data
public class Test {

    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "地址")
    private String address;
}

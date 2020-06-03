package com.zt.test.query;

import com.zt.entiy.RequestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZT
 * @date 2020/6/3
 */
@ApiModel("测试查询")
@Data
public class TestQuery extends RequestParam {

    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "姓名")
    private String name;
}

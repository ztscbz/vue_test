package com.zt.test.query;

import com.zt.entiy.RequestParam;
import com.zt.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ZT
 * @date 2020/6/3
 */
@ApiModel("测试查询")
@Data
public class TestQuery extends RequestParam {

    @NotBlank(message = "主键Id不能为空",groups = {Update.class})
    @ApiModelProperty(value = "主键Id")
    private String id;

    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名")
    private String name;

    @NotEmpty(message = "id集合不能为空")
    @ApiModelProperty(value = "id集合")
    private List<String> ids;

    @Override
    public String toString() {
        return "TestQuery{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", ids=" + ids +
                '}';
    }
}

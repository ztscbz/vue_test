package com.zt.entiy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: TreeNode
 * @Description:
 * @author: ZT
 * @date: 2020/4/22 16:14
 */
@Data
@ApiModel(value = "树-实体类")
public class TreeNode {
    @ApiModelProperty(value = "主键pk")
    private String id;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(value = "等级")
    private String level;

    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "名称")
    private String label;

    @ApiModelProperty(value = "子节点")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeNode> children = Lists.newArrayList();//子节点

}

package com.zt.test.mapper;

import com.zt.entiy.TreeNode;
import com.zt.test.po.TestVo;
import com.zt.test.query.TestQuery;

import java.util.List;

/**
 * @author ZT
 * @date 2020/6/3
 */
public interface TestMapper {

    List<TestVo> queryTest(TestQuery param);

    List<TreeNode> queryTreeNode();
}

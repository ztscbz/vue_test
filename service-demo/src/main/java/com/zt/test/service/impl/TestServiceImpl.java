package com.zt.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.entiy.TreeNode;
import com.zt.test.mapper.TestMapper;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;
import com.zt.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ZT
 * @date 2020/6/3
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper mapper;

    @Override
    public PageInfo<Test> queryTest(TestQuery param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        PageInfo info = new PageInfo(mapper.queryTest(param));
        return info;
    }

    @Override
    public List<TreeNode> queryTreeNode(String id) {
        List<TreeNode> arr = mapper.queryTreeNode();
        List<TreeNode> root = arr.stream().filter(e -> Objects.equals(id, e.getId())).collect(Collectors.toList());//获取根
        for (TreeNode perm : root) {
            findChildPerms(perm, arr);
        }
        return root;
    }

    private void findChildPerms(TreeNode treeNode, List<TreeNode> allPerm) {
        List<TreeNode> childPerms = allPerm.stream().filter(child -> treeNode.getId().equals(child.getParentId()))
                .sorted(Comparator.comparing(TreeNode::getOrderNum))
                .collect(Collectors.toList());
        if (childPerms != null && childPerms.size() > 0) {
            treeNode.getChildren().addAll(childPerms);
            for (TreeNode perm : childPerms) {
                findChildPerms(perm, allPerm);
            }
        }

    }
}

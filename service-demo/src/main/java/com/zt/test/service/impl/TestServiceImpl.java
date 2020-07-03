package com.zt.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.entiy.TreeNode;
import com.zt.test.mapper.TestMapper;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;
import com.zt.test.service.TestService;
import com.zt.util.MinioUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
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
        if(StringUtils.isBlank(id)){
            for (TreeNode treeNode : arr) {
                if(StringUtils.equals(treeNode.getParentId(),null)){
                    id = treeNode.getId();
                }
            }
        }
        String finalId = id;
        List<TreeNode> root = arr.stream().filter(e -> Objects.equals(finalId, e.getId())).collect(Collectors.toList());//获取根
        for (TreeNode perm : root) {
            findChildPerms(perm, arr);
        }
        return root;
    }

    @Override
    public String upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String last = originalFilename.substring(originalFilename.lastIndexOf("."));
        LocalDate localDate = LocalDate.now();
        //设置minio桶路径
        String bucketName = String.valueOf(localDate.getYear());
        //设置资源路径
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        String resourceName = localDate.format(dtf).concat("/").concat(String.valueOf(new Date().getTime())).concat(last);
        MinioUtil.upload(bucketName,file, resourceName);
        return bucketName.concat("/").concat(resourceName);
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

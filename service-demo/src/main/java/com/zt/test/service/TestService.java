package com.zt.test.service;

import com.github.pagehelper.PageInfo;
import com.zt.entiy.TreeNode;
import com.zt.test.po.Test;
import com.zt.test.query.TestQuery;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ZT
 * @date 2020/6/3
 */
public interface TestService {

    /**
     * @description: 测试查询
     * @author ZT
     * @Date 2020/6/3 20:16
     * @Param  @param param
     * @return com.github.pagehelper.PageInfo<com.zt.test.po.Test>
    */
    PageInfo<Test> queryTest(TestQuery param);

    /**
     * @author: ZT
     * @date: 2020/6/4 17:20
     * @Title: queryTreeNode
     * @Description: 树查询
     * @param:  * @param id
     * @return: java.util.List<com.zt.entiy.TreeNode>
     */
    List<TreeNode> queryTreeNode(String id);

    /**
     * @author: ZT
     * @date: 2020/7/3 15:41
     * @Title: upload
     * @Description: 文件上传
     * @param:  * @param file
     * @return: java.lang.String
     */
    String upload(MultipartFile file);
}

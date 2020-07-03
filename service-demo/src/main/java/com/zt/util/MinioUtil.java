package com.zt.util;

import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: MinioUtil
 * @Description:
 * @author: ZT
 * @date: 2020/7/3 9:13
 */
@Slf4j
@Component
public class MinioUtil {

    private static MinioClient minioClient;

    @Autowired
    public void setMinioClient(MinioClient minioClient) {
        MinioUtil.minioClient = minioClient;
    }

    public static void upload(String bucketName, MultipartFile file, String resourceName) {
        if(StringUtils.isBlank(bucketName)) throw new RuntimeException("数据桶不能为空");
        try {
            // 检查存储桶是否已经存在
            boolean exists = minioClient.bucketExists(bucketName);
            if (!exists) {
                // 创建一个名为bucketName的存储桶
                minioClient.makeBucket(bucketName);
                // 设置桶的访问策略为可读可写
                minioClient.setBucketPolicy(bucketName,"*", PolicyType.READ_WRITE);
                log.info("创建一个数据桶{}" + bucketName);
            }
            minioClient.putObject(bucketName, resourceName,
                    file.getInputStream(), file.getInputStream().available(), file.getContentType());
        }catch (Exception e){
            throw new RuntimeException("文件上传错误: "+e);
        }

    }
}

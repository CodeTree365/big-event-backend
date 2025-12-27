package com.itheima.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/11/10
 */
public class AliOssUtil {
    // Endpoint以华东2（北京）为例，其它Region请按实际情况填写。
    private static final String ENDPOINT = System.getenv("ALI_OSS_ENDPOINT");
    // 阿里云访问密钥ID
    private static final String ACCESS_KEY_ID = System.getenv("ALI_ACCESS_KEY_ID");
    // 阿里云访问密钥Secret
    private static final String ACCESS_KEY_SECRET = System.getenv("ALI_ACCESS_KEY_SECRET");
    // Bucket名称
    private static final String BUCKET_NAME = System.getenv("ALI_OSS_BUCKET_NAME");
    // Bucket所在地域
    private static final String REGION = System.getenv("ALI_OSS_REGION");

    public static String uploadFile(String objectName, InputStream inputStream) throws Exception {

        // 创建OSSClient实例。
        // 当OSSClient实例不再使用时，调用shutdown方法以释放资源。
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(ENDPOINT)
                .credentialsProvider(new DefaultCredentialProvider(ACCESS_KEY_ID, ACCESS_KEY_SECRET))
                .clientConfiguration(clientBuilderConfiguration)
                .region(REGION)
                .build();
        String url = "";
        try {
            // 填写字符串。
            String content = "Hello OSS，你好世界";

            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, inputStream);

            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传字符串。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            // URL组成：https://{BucketName}.{Endpoint}/{ObjectName}
            url = "https://" + BUCKET_NAME + "." + ENDPOINT.substring(ENDPOINT.lastIndexOf("/") + 1) + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}
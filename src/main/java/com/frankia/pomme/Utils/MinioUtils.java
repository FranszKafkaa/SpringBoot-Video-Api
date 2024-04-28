package com.frankia.pomme.Utils;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import io.minio.*;
import io.minio.messages.Bucket;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class MinioUtils {
    private final MinioClient minioClient;

    @SneakyThrows(Exception.class)
    private void createBucket(String BucketName) {
        if (!bucketExists(BucketName)) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(BucketName).build());
        }
    }

    @SneakyThrows(Exception.class)
    public boolean bucketExists(String bucketName) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    @SneakyThrows(Exception.class)
    public String getBucketPolicy(String bucketName) {
        return minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
    }

    @SneakyThrows(Exception.class)
    public List<Bucket> getAllbuckets() {
        return minioClient.listBuckets();
    }

    @SneakyThrows(Exception.class)
    public Optional<Bucket> getBucket(String bucketName) {
        return getAllbuckets().stream().filter(b -> b.name().equals(bucketName)).findFirst();
    }

    @SneakyThrows(Exception.class)
    public void removeBucket(String bucketName) {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /**
     * use MultipartFile to upload files
     *
     * @param bucketName
     * @param file
     * @param objectName
     * @param contentType
     * @return io.minio.ObjectWriteResponse
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, MultipartFile file, String objectName,
            String contentType) {
        InputStream inputStream = file.getInputStream();

        return minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .contentType(contentType)
                .stream(inputStream, inputStream.available(), -1).build());
    }
}

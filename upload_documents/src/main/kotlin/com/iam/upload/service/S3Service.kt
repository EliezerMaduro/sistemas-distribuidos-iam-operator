package com.iam.upload.service;
 
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;
 
@Service
class S3Service @Autowired constructor(private val s3Client: S3Client) {
 
    fun uploadFile(file: MultipartFile): String {
        val bucketName = "iam-operator"
        val fileName = "${UUID.randomUUID()}-${file.originalFilename}"
 
        try {
            val fileBytes = file.bytes
 
            val request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build()
 
            s3Client.putObject(request, RequestBody.fromBytes(fileBytes))
            val objectUrl = s3Client.utilities().getUrl {
                it.bucket(bucketName).key(fileName)
            }.toExternalForm()
 
            return objectUrl
        } catch (e: IOException) {
            throw RuntimeException("Failed to upload file to S3", e)
        }
    }
}
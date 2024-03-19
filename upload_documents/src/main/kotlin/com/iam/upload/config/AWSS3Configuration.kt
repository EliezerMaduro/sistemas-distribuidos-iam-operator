package com.iam.upload.config;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
 
@Configuration
class AWSS3Configuration {
 
    @Bean
    fun s3Client(): S3Client {
        val accessKeyId = "---"
        val secretAccessKey = "-----"
        val region = Region.US_EAST_1
 
        val credenciales = AwsBasicCredentials.create(accessKeyId, secretAccessKey)
        val credencialesProveedor = StaticCredentialsProvider.create(credenciales)
 
        return S3Client.builder()
            .credentialsProvider(credencialesProveedor)
            .region(region)
            .build()
    }
}
package com.iam.upload.config;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client

import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.annotation.Autowired

@Configuration
class AWSS3Configuration @Autowired constructor(
    @Value("\${aws.accessKeyId}") private val awsAccessKeyId: String,
    @Value("\${aws.secretAccessKey}") private val awsSecretAccessKey: String
    ){
 
    @Bean
    fun s3Client(): S3Client {
        val accessKeyId = awsAccessKeyId
        val secretAccessKey = awsSecretAccessKey
        val region = Region.US_EAST_1
 
        val credenciales = AwsBasicCredentials.create(accessKeyId, secretAccessKey)
        val credencialesProveedor = StaticCredentialsProvider.create(credenciales)
 
        return S3Client.builder()
            .credentialsProvider(credencialesProveedor)
            .region(region)
            .build()
    }
}
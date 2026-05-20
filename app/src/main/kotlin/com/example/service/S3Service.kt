package com.example.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request

@Service
class S3Service {

    private val s3Client: S3Client by lazy {
        S3Client.builder().build()
    }

    suspend fun listObjects(bucket: String): List<String> = withContext(Dispatchers.IO) {
        val request = ListObjectsV2Request.builder().bucket(bucket).build()
        val response = s3Client.listObjectsV2(request)
        response.contents().map { it.key() }
    }
}
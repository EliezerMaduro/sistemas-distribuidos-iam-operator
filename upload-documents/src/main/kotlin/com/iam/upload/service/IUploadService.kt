package com.iam.upload.service;

import org.springframework.web.multipart.MultipartFile
import com.iam.upload.model.Document

interface IUploadService{
    fun uploadDocument(file: MultipartFile): String
    fun getAllDocuments(): List<Document>
}
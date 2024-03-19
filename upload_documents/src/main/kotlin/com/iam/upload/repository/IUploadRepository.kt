package com.iam.upload.repository;

import org.springframework.web.multipart.MultipartFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.iam.upload.model.Document

@Repository
public interface IUploadRepository: JpaRepository<Document,Int> {
    
}

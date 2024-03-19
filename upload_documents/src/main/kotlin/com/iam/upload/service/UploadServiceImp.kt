package com.iam.upload.service;
 
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.util.UUID
import com.iam.upload.repository.IUploadRepository
import com.iam.upload.service.IUploadService
 
@Service
@Transactional
public class UploadServiceImp (private val UploadRepository: IUploadRepository) : IUploadService {
    override fun uploadDocument(file: MultipartFile): String {
        val fileName = "${UUID.randomUUID()}-${file.originalFilename}"
        val url = "ruta_s3/$fileName" // Cambiar por la lógica real de S3
        // Aquí puedes guardar los detalles del documento en la base de datos si es necesario
        return url
    }
}
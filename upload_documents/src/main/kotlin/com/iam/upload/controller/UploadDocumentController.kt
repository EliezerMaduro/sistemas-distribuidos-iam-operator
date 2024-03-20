package com.iam.upload.controller;

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus


import com.iam.upload.service.IUploadService
import com.iam.upload.service.S3Service

@RestController
@RequestMapping("/v1/documents")
class UploadDocumentController @Autowired constructor(
    private val s3service: S3Service
    ){
    @PostMapping("/upload")
    fun uploadDocument(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        try {
            // Subir el archivo al bucket de S3
            val url = s3service.uploadFile(file)
            return ResponseEntity.ok("Documento cargado exitosamente. URL: $url")
        } catch (e: Exception) {
            // Manejar cualquier excepción que ocurra durante la carga del documento
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al cargar el documento: ${e.message}")
        }
    }
}
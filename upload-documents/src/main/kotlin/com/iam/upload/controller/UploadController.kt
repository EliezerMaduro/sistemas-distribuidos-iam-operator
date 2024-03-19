package com.iam.upload.controller;

import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/v1/documents")
class UploadController @Autowire(){

    @PostMapping("/upload")
    fun uploadDocument(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        val url = documentService.uploadDocument(file)
        return ResponseEntity.ok("Documento cargado exitosamente. URL: $url")
    }
}
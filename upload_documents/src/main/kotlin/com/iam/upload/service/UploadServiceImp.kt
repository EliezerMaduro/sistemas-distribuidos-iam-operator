package com.iam.upload.service;

import com.iam.upload.model.Document
import com.iam.upload.repository.IUploadRepository

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.OkHttpClient
import okhttp3.Request


import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

import java.util.UUID
import java.io.IOException


@Service
@Transactional
public class UploadServiceImp (private val UploadRepository: IUploadRepository) : IUploadService {
    override fun uploadDocument(file: MultipartFile): String {
        val fileName = "${UUID.randomUUID()}-${file.originalFilename}"
        val url = "ruta_s3/$fileName" // Cambiar por la lógica real de S3
        // Aquí puedes guardar los detalles del documento en la base de datos si es necesario
        return url
    }

    override fun saveDocument(documentData: Document): Document {
        // Guardar los datos del documento en la base de datos
        return UploadRepository.save(documentData)
    }

    @Value("\${govcarpeta.url}")
    private lateinit var govCarpetaUrl: String
    
    
    fun authenticateDocument(idCitizen: Int, urlDocument: String, documentTitle: String): String {

        val json = """
            {
                "idCitizen": $idCitizen,
                "UrlDocument": "$urlDocument",
                "documentTitle": "$documentTitle"
            }
        """.trimIndent()
    
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val requestBody = json.toRequestBody(mediaType)
        
        val httpClient = OkHttpClient()
        val request = Request.Builder()
            .url(govCarpetaUrl)
            .put(requestBody)
            .build()
        
        try {
            val response = httpClient.newCall(request).execute()
            val responseBody = response.body?.string()
            println("Server Response:")
            println(responseBody)
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return responseBody.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            return "Failed to authenticate the document!"
        }
    }
}
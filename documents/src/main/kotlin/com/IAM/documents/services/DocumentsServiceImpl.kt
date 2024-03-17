package com.IAM.documents.services;

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.IAM.documents.repository.IDocumentsRepository
import com.IAM.documents.model.Document
import com.IAM.documents.services.IDocumentsService


@Service
@Transactional
class DocumentsServiceImpl @Autowired constructor(private val documentsRepository: IDocumentsRepository) : IDocumentsService{
    

    override fun obtenerDocumentos(id: Int): Document? {
        return documentsRepository.findById(id).orElse(null)
    }
}

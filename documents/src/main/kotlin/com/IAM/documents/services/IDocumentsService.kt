package com.IAM.documents.services;

import com.IAM.documents.model.Document

interface IDocumentsService {
    // fun obtenerPersona(id: Int): Persona?
    // fun guardarPersona(persona: Persona): Persona
    // fun actualizarPersona(id: Int, nuevaPersona: Persona): Persona
    // fun eliminarPersona(id: Int)
    fun obtenerDocumentos(limit: Int?, page: Int?, sort_order: String?, sort_column: String?, idCitizen: Int?): List<Document>
    fun obtenerAllDocumentos(): List<Document>
}

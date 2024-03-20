package com.iam.create_package.controller;

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.beans.factory.annotation.Autowired

import com.iam.create_package.service.IPackageService
import com.iam.create_package.service.PackageServiceImp
import com.iam.create_package.model.PackageModel

@RestController
@RequestMapping("/v1/documents")
class packageController (private val PackageService: PackageServiceImp){

    @PostMapping("/create-package")
    fun createPackage(@RequestBody request: PackageModel):ResponseEntity<PackageModel> {
        val savedPackage = PackageService.savePackage(request)
        return ResponseEntity(savedPackage, HttpStatus.CREATED)
    }
}
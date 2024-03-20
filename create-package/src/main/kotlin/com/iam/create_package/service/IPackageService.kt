package com.iam.create_package.service;

import org.springframework.web.bind.annotation.RequestBody
import com.iam.create_package.model.PackageModel

interface IPackageService {
    fun savePackage(packageModel: PackageModel): PackageModel
}

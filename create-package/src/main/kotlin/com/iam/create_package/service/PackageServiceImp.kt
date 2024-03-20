package com.iam.create_package.service;

import org.springframework.stereotype.Service
import jakarta.transaction.Transactional
import com.iam.create_package.repository.IPackageRepository
import com.iam.create_package.model.PackageModel

@Service
@Transactional
public class PackageServiceImp (private val packageRepository: IPackageRepository){
    fun savePackage(packageModel: PackageModel): PackageModel {
        return packageRepository.save(packageModel)
    }
}

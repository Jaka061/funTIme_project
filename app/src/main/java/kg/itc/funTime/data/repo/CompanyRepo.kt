package kg.itc.funTime.data.repo

import io.reactivex.Single
import kg.itc.funTime.data.models.CompanyDto
import kg.itc.funTime.data.models.CompanyEntity
import kg.itc.funTime.data.network.CompanyApi
import kg.itc.funTime.data.storage.CompanyDao
import javax.inject.Inject

class CompanyRepo @Inject constructor(
    private var companyDao: CompanyDao,
    private var companyApi : CompanyApi
) {

    fun getCompanyFromApi() = companyApi.getCompanies()

    fun getCompanyById(objectId : String) : Single<List<CompanyDto>>{
        return companyApi.getCompanyById(objectId)
    }

    fun getCompanyFromDB() = companyDao.getAll()

    fun saveCompanyToDb(company: List<CompanyEntity>) {
        companyDao.insert(company)
    }
}
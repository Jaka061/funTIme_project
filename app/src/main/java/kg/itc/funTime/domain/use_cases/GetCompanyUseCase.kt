package kg.itc.funTime.domain.use_cases

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kg.itc.funTime.data.models.CompanyEntity
import kg.itc.funTime.data.repo.CompanyRepo
import kg.itc.funTime.extensions.toCompanyEntity
import javax.inject.Inject

class GetCompanyUseCase @Inject constructor(
    private val companyRepo: CompanyRepo) {

    operator fun invoke(): Observable<Unit> {
        return companyRepo.getCompanyFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                val companies = mutableListOf<CompanyEntity>()
                it.forEach {
                    companies.add(it.toCompanyEntity())
                }
               companies.toList()
            }
            .map {
                companyRepo.saveCompanyToDb(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}
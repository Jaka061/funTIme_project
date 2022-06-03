package kg.itc.funTime.domain.use_cases

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kg.itc.funTime.data.models.TypesEntity
import kg.itc.funTime.data.repo.TypesRepo
import kg.itc.funTime.extensions.toTypesEntity
import javax.inject.Inject

class GetTypesUseCase @Inject constructor(
    private val typedRepo: TypesRepo
) {
    operator fun invoke(): Observable<Unit> {
        return typedRepo.getTypesFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                val types = mutableListOf<TypesEntity>()
                it.forEach {
                    types.add(it.toTypesEntity())
                }
                types.toList()
            }
            .map {
                typedRepo.saveTypesToDb(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}
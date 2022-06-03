package kg.itc.funTime.domain.use_cases

import androidx.lifecycle.LiveData
import kg.itc.funTime.data.models.TypesEntity
import kg.itc.funTime.data.repo.TypesRepo
import javax.inject.Inject

class GetTypesAsLiveDataUseCase  @Inject constructor(
    private val typedRepo: TypesRepo
) {

    operator fun invoke(): LiveData<List<TypesEntity>> {
        return typedRepo.getTypesFromDB()
    }
}
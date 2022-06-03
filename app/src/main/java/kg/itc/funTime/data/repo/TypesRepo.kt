package kg.itc.funTime.data.repo

import io.reactivex.Single
import kg.itc.funTime.data.models.TypesDto
import kg.itc.funTime.data.models.TypesEntity
import kg.itc.funTime.data.network.TypesApi
import kg.itc.funTime.data.storage.TypeDao
import javax.inject.Inject

class TypesRepo @Inject constructor(
    private var typeDao: TypeDao,
    private var typesApi: TypesApi
) {
    fun getTypesFromApi() = typesApi.getTypes()

    fun getTypesById(objectId : String) : Single<List<TypesDto>>{
        return typesApi.getTypesById(objectId)
    }

    fun createType(typesDto: TypesDto) = typesApi.saveType(typesDto)

    fun getTypesFromDB() = typeDao.getAll()

    fun saveTypesToDb(types: List<TypesEntity>) {
        typeDao.insert(types)
    }
}
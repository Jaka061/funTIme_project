package kg.itc.funTime.data.network

import io.reactivex.Observable
import io.reactivex.Single
import kg.itc.funTime.data.models.TypesDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TypesApi {

    @GET("/api/data/types")
    fun getTypes(): Observable<List<TypesDto>>

    @GET("/api/data/types/{objectId}")
    fun getTypesById(@Path("objectId") objectId:String): Single<List<TypesDto>>

    @POST("/api/data/types")
    fun insert(typesDto: TypesDto)

    @POST("/api/data/types")
    fun saveType(@Body typeOfCompany: TypesDto): Observable<Unit>
}
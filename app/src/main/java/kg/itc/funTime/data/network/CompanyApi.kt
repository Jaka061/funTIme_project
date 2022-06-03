package kg.itc.funTime.data.network

import io.reactivex.Observable
import io.reactivex.Single
import kg.itc.funTime.data.models.CompanyDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CompanyApi {

    @GET("/api/data/company")
    fun getCompanies(): Observable<List<CompanyDto>>

    @GET("/api/data/company/{objectId}")
    fun getCompanyById(@Path("objectId") objectId:String): Single<List<CompanyDto>>

    @POST("/api/data/company")
    fun insert(companyDto: CompanyDto)

    @POST("/api/data/company")
    fun saveCompany(@Body companyDto: CompanyDto): Observable<Unit>
}
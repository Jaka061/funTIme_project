package kg.itc.funTime.data.network

import io.reactivex.Observable
import io.reactivex.Single
import kg.itc.funTime.data.models.UserDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {

    @GET("data/User")
    fun getUsers(): Observable<List<UserDto>>

    @GET("data/User/{objectId}")
    fun getUserById(@Path("objectId") objectId:String): Single<List<UserDto>>

    @POST("data/User")
    fun insertUser(userDto: UserDto)
}
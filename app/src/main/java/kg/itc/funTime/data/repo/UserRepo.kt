package kg.itc.funTime.data.repo

import io.reactivex.Single
import kg.itc.funTime.data.models.UserDto
import kg.itc.funTime.data.models.UserEntity
import kg.itc.funTime.data.network.UserApi
import kg.itc.funTime.data.storage.UserDao
import javax.inject.Inject

class UserRepo @Inject constructor(
    private var userDao: UserDao,
    private var userApi: UserApi
) {

    fun getUserFromApi() = userApi.getUsers()

    fun getUserById(objectId : String) = userDao.getUserById(objectId)

    fun getUserId(objectId: String): Single<List<UserDto>> {
        return userApi.getUserById(objectId)
    }

    fun clearTable() {
        userDao.clearTable()
    }

    fun saveUsersToDb(users: List<UserEntity>) = userDao.insertUsers(users)

}
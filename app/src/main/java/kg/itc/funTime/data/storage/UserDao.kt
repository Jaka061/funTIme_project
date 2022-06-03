package kg.itc.funTime.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import kg.itc.funTime.data.models.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM UserEntity WHERE objectId = :objectId")
    fun getUserById(objectId : String): LiveData<UserEntity>

    @Query("DELETE FROM UserEntity")
    fun clearTable()

    @Insert
    fun insertUsers(user: List<UserEntity>): Completable
}
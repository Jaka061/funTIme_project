package kg.itc.funTime.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import kg.itc.funTime.data.models.TypesEntity

@Dao
interface TypeDao {

    @Query("SELECT * FROM TypesEntity")
    fun getAll(): LiveData<List<TypesEntity>>

    @Query("SELECT * FROM TypesEntity WHERE objectId = :objectId ")
    fun getTypesById(objectId : String): Single<TypesEntity>

    @Query("DELETE FROM TypesEntity")
    fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeOfCompanies: List<TypesEntity>)

    @Insert
    fun insertTypes(types : List<TypesEntity>): Completable
}

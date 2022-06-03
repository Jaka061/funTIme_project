package kg.itc.funTime.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import kg.itc.funTime.data.models.CompanyEntity

@Dao
interface CompanyDao {

    @Query("SELECT * FROM CompanyEntity")
    fun getAll(): LiveData<List<CompanyEntity>>

    @Query("SELECT * FROM CompanyEntity WHERE objectId = :objectId ")
    fun getTypesById(objectId : String): Single<CompanyEntity>

    @Query("DELETE FROM CompanyEntity")
    fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(companies: List<CompanyEntity>)

    @Insert
    fun insertTypes(companies: List<CompanyEntity>): Completable
}

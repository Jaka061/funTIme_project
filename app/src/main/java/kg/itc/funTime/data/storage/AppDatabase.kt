package kg.itc.funTime.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.itc.funTime.data.models.CompanyEntity
import kg.itc.funTime.data.models.TypesEntity
import kg.itc.funTime.data.models.UserEntity

//@TypeConverters(TypeListConverter::class)
@Database(entities = [UserEntity::class,CompanyEntity::class,TypesEntity::class] ,version = 4)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun userDao(): UserDao
    abstract fun typesDao(): TypeDao
    abstract fun companyDao() : CompanyDao

    companion object {
        const val DB_NAME = "funTime.db"
    }
}
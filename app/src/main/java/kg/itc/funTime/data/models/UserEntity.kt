package kg.itc.funTime.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    var objectId: String,
    var name: String,
    var surname: String,
    var email:String,
    var age: Int,
    var password:String
)
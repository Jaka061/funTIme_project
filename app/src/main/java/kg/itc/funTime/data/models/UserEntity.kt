package kg.itc.funTime.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    var objectId: String,
    var login: String,
    var email:String,
    var password:String
)
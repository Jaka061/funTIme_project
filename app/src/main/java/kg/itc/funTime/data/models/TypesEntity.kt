package kg.itc.funTime.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TypesEntity(
    @PrimaryKey
    var objectId : String,
    var name : String,
    var img : String,
    val count : String
)
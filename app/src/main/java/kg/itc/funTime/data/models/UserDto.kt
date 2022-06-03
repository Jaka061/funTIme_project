package kg.itc.funTime.data.models

data class UserDto(
    var objectId: String,
    var name: String,
    var surname: String,
    var email:String,
    var age: Int,
    var password:String
)

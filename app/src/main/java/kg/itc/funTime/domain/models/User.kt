package kg.itc.funTime.domain.models

data class User(
    var objectId: String,
    var name: String,
    var surname: String,
    var email:String,
    var age: Int,
    var password:String
)

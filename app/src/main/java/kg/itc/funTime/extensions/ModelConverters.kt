package kg.itc.funTime.extensions

import kg.itc.funTime.data.models.*
import kotlin.math.log

fun UserDto.toUserEntity(): UserEntity {
    return UserEntity(
        objectId = this.objectId,
        login = this.login,
        email = this.email,
        password = this.password,
    )
}

fun CompanyDto.toCompanyEntity(): CompanyEntity {
    return CompanyEntity(
        objectId = this.objectId,
        name = this.name,
        description = this.description,
        type = this.type,
        region = this.region,
        email = this.email,
        number = this.number,
        instagram = this.instagram,
        img = this.img
    )
}

fun TypesDto.toTypesEntity(): TypesEntity{
    return TypesEntity(
        objectId = this.objectId,
        name = this.name,
        img = this.img,
        count = this.count
    )
}

